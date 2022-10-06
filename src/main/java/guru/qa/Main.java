package guru.qa;

import guru.qa.service.ChoiceInterface;
import guru.qa.service.UserInterface;

public class Main {
    public static void main(String[] args) {
        ChoiceInterface choiceInterface = new ChoiceInterface(args);
        UserInterface userInterface = choiceInterface.selectInterfaceTypeFromArgs();

        new Application(userInterface).run();
    }
}
