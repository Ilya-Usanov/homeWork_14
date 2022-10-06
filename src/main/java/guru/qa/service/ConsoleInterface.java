package guru.qa.service;

import guru.qa.entity.CarEntity;
import guru.qa.entity.TrackEntity;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import java.util.Scanner;

public class ConsoleInterface extends UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public ConsoleInterface(CarStore carStore, TrackStore trackStore) {
        super(carStore, trackStore);
        System.out.println("Console interface created");
    }

    @Override
    public CarEntity chooseCar() {
        System.out.println("Car:");
        String desiredCar = scanner.next();
        return carStore.lookup(desiredCar);
    }

    @Override
    public TrackEntity chooseTrack() {
        System.out.println("Track:");
        String desiredTrack = scanner.next();
        return trackStore.lookup(desiredTrack);
    }

    @Override
    public void showResult(CarEntity car, TrackEntity track) {
        System.out.println("Результат:");
        if (car.isPitstopNeeded(track)) {
            System.out.println("Pit-stop needed in " + car.maxLapsForTrack());
        } else {
            System.out.println("Pit-stop not needed");
        }
    }
}
