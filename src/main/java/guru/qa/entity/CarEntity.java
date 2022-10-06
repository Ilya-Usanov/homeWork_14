package guru.qa.entity;

public class CarEntity {
    private int id;
    private String brand;
    private double fuelEconomy;

    public int getId() {
        return id;
    }

    public CarEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public double getFuelEconomy() {
        return fuelEconomy;
    }

    public CarEntity setFuelEconomy(double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
        return this;
    }

    private static final int FUEL_CAPACITY = 100;

    private int maxLapsForTrack;

    public int fuelCapacity() {
        return FUEL_CAPACITY;
    }

    public boolean isPitstopNeeded(TrackEntity track) {
        maxLapsForTrack(track);
        return maxLapsForTrack < track.getLaps();
    }

    public int maxLapsForTrack() {
        return this.maxLapsForTrack;
    }

    private void maxLapsForTrack(TrackEntity track) {
        int lapDistance = track.getLapDistance();
        double fuelEconomy = getFuelEconomy();
        int fuelCapacity = fuelCapacity();
        double maxDistanceForCar = fuelCapacity * 100 / fuelEconomy;
        this.maxLapsForTrack = (int) ((maxDistanceForCar * 1000) / lapDistance);
    }
}
