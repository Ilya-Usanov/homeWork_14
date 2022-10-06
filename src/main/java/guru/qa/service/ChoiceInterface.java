package guru.qa.service;

import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ChoiceInterface {
    private Options options = new Options();
    private CommandLine cmd;

    public ChoiceInterface(String[] args) {
        addInterfaceArgument();
        cmd = getCmd(args);
    }


    public UserInterface selectInterfaceTypeFromArgs() {
        String interfaceType = cmd.getOptionValue("i");

        UserInterface userInterface;
        if (interfaceType == null || interfaceType.equals("gui")) {
            userInterface = new GuiInterface(
                    new CarStore(),
                    new TrackStore()
            );
        } else {
            userInterface = new ConsoleInterface(
                    new CarStore(),
                    new TrackStore()
            );
        }
        return userInterface;
    }

    private CommandLine getCmd(String[] args) {
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        return cmd;
    }

    private void addInterfaceArgument() {
        Option option = new Option("i",
                "interface",
                true,
                "interface type: gui or console");
        option.setRequired(false);

        options.addOption(option);
    }
}
