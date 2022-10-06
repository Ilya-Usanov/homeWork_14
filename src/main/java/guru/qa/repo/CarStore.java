package guru.qa.repo;

import guru.qa.domain.CarRepository;
import guru.qa.domain.impl.PostgresCarRepository;
import guru.qa.entity.CarEntity;

public class CarStore {

    private CarRepository carRepository = new PostgresCarRepository();

    public CarEntity lookup(String carBrand) {
        CarEntity car = carRepository.getByBrand(carBrand);

        if (car != null) {
            return car;
        }

        throw new IllegalArgumentException("Car not found for given name: " + carBrand);
    }

    public Object[] carModelNames() {
        return carRepository.getAllNames();
    }
}
