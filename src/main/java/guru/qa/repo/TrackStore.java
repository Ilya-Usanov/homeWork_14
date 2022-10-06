package guru.qa.repo;

import guru.qa.domain.TrackRepository;
import guru.qa.domain.impl.PostgresTrackRepository;
import guru.qa.entity.TrackEntity;

public class TrackStore {

    private TrackRepository trackRepository = new PostgresTrackRepository();

    public TrackEntity lookup(String trackName) {
        TrackEntity track = trackRepository.getByTrack(trackName);

        if (track != null) {
            return track;
        }

        throw new IllegalArgumentException("Track not found for given name: " + trackName);
    }

    public Object[] trackNames() {
        return trackRepository.getAllNames();
    }
}
