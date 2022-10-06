package guru.qa.domain;

import guru.qa.entity.TrackEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackEntityRowMapper implements RowMapper<TrackEntity> {

    @Override
    public TrackEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TrackEntity()
                .setId(rs.getInt("id"))
                .setTrack(rs.getString("track"))
                .setLaps(rs.getInt("laps"))
                .setLapDistance(rs.getInt("lap_distance"));
    }
}
