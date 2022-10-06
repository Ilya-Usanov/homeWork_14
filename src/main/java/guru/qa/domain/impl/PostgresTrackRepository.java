package guru.qa.domain.impl;

import guru.qa.domain.DataSourceProvider;
import guru.qa.domain.TrackEntityRowMapper;
import guru.qa.domain.TrackRepository;
import guru.qa.entity.TrackEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

import java.util.List;

public class PostgresTrackRepository implements TrackRepository {

    private static final JdbcTemplate template =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    @Override
    public List<TrackEntity> getAll() {
        return template.query("SELECT * FROM world_tracks", new TrackEntityRowMapper());
    }

    @Override
    public Object[] getAllNames() {
        Object[] result = template.queryForList("SELECT track FROM world_tracks", String.class).toArray();
        return result;
    }

    @Override
    public @Nullable
    TrackEntity getByTrack(String trackTrack) {
        try {
            return template.queryForObject("SELECT * FROM world_tracks WHERE track = ?", new TrackEntityRowMapper(), trackTrack);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void addTrack(TrackEntity track) {
        template.update("INSERT INTO world_tracks (track , laps, lap_distance ) values (? , ?, ?)", track.getTrack(), track.getLaps(), track.getLapDistance());
    }

    @Override
    public void updateTrack(TrackEntity track) {
        template.update("UPDATE world_tracks SET track = ?, laps = ?, lap_distance = ?", track.getTrack(), track.getLaps(), track.getLapDistance());
    }
}
