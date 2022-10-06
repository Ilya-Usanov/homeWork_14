package guru.qa.domain;

import guru.qa.entity.CarEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarEntityRowMapper implements RowMapper<CarEntity> {

    @Override
    public CarEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CarEntity()
                .setId(rs.getInt("id"))
                .setBrand(rs.getString("brand"))
                .setFuelEconomy(rs.getDouble("fuel_Economy"));
    }
}
