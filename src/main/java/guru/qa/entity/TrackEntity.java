package guru.qa.entity;

public class TrackEntity {
    private int id;
    private String track;
    private int laps;
    private int lapDistance;

    public int getId() {
        return id;
    }

    public TrackEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getTrack() {
        return track;
    }

    public TrackEntity setTrack(String track) {
        this.track = track;
        return this;
    }

    public int getLaps() {
        return laps;
    }

    public TrackEntity setLaps(int laps) {
        this.laps = laps;
        return this;
    }

    public int getLapDistance() {
        return lapDistance;
    }

    public TrackEntity setLapDistance(int lapDistance) {
        this.lapDistance = lapDistance;
        return this;
    }
}
