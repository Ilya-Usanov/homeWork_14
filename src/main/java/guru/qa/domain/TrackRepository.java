package guru.qa.domain;

import guru.qa.entity.TrackEntity;

import java.util.List;

public interface TrackRepository {

    Object[] getAllNames();

    TrackEntity getByTrack(String trackTrack);
}
