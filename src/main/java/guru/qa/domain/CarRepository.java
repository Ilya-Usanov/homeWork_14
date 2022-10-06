package guru.qa.domain;

import guru.qa.entity.CarEntity;

import java.util.List;

public interface CarRepository {

    Object[] getAllNames();

    CarEntity getByBrand(String carBrand);
}
