package guru.qa.service;

import guru.qa.entity.CarEntity;
import guru.qa.entity.TrackEntity;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

public abstract class UserInterface {
    protected final CarStore carStore;
    protected final TrackStore trackStore;

    public UserInterface(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    public abstract CarEntity chooseCar();

    public abstract TrackEntity chooseTrack();

    public abstract void showResult(CarEntity car, TrackEntity track);
}
