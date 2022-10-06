package guru.qa.domain.impl;

import guru.qa.domain.CarEntityRowMapper;
import guru.qa.domain.CarRepository;
import guru.qa.domain.DataSourceProvider;
import guru.qa.entity.CarEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

import java.util.List;

public class PostgresCarRepository implements CarRepository {

    private static final JdbcTemplate template =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    @Override
    public List<CarEntity> getAll() {
        return template.query("SELECT * FROM world_cars", new CarEntityRowMapper());
    }

    @Override
    public Object[] getAllNames() {
        Object[] result = template.queryForList("SELECT brand FROM world_cars", String.class).toArray();
        return result;
    }

    @Override
    public @Nullable
    CarEntity getByBrand(String carBrand) {
        try {
            return template.queryForObject("SELECT * FROM world_cars WHERE brand = ?", new CarEntityRowMapper(), carBrand);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void addCar(CarEntity car) {
        template.update("INSERT INTO world_cars (brand , fuel_economy ) values (? , ?)", car.getBrand(), car.getFuelEconomy());
    }

    @Override
    public void updateCar(CarEntity car) {
        template.update("UPDATE world_cars SET brand = ?, fuel_economy = ?", car.getBrand(), car.getFuelEconomy());
    }
}
