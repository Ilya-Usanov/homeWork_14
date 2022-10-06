package guru.qa;

import guru.qa.entity.CarEntity;
import guru.qa.entity.TrackEntity;
import guru.qa.service.UserInterface;

public class Application {

    private final UserInterface userInterface;

    public Application(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    void run() {
        CarEntity car = userInterface.chooseCar();
        TrackEntity track = userInterface.chooseTrack();
        userInterface.showResult(car, track);
    }
}
