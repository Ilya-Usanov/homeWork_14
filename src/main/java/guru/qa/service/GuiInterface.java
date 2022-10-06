package guru.qa.service;

import guru.qa.entity.CarEntity;
import guru.qa.entity.TrackEntity;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import javax.swing.*;

public class GuiInterface extends UserInterface {

    public GuiInterface(CarStore carStore, TrackStore trackStore) {
        super(carStore, trackStore);
    }

    @Override
    public CarEntity chooseCar() {
        Object[] selectionValues = carStore.carModelNames();
        String desiredCar =
                (String) JOptionPane.showInputDialog(null,
                        "Choose a car model:",
                        "Car",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        selectionValues,
                        selectionValues[0]
                );
        return carStore.lookup(desiredCar);
    }

    @Override
    public TrackEntity chooseTrack() {
        Object[] selectionValues = trackStore.trackNames();
        String desiredTrack =
                (String) JOptionPane.showInputDialog(null,
                        "Choose a track:",
                        "Track",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        selectionValues,
                        selectionValues[0]
                );
        return trackStore.lookup(desiredTrack);
    }

    public void showResult(CarEntity car, TrackEntity track) {
        if (car.isPitstopNeeded(track)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Pit-stop needed in " + car.maxLapsForTrack(),
                    "Результат:",
                    1
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Pit-stop not needed ",
                    "Результат:",
                    1
            );
        }
    }
}
