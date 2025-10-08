package ru.innopolis.java;

import ru.innopolis.java.repositories.CarRepository;
import ru.innopolis.java.repositories.impl.CarRepositoryFileImpl;

public class App {
    public static void main(String[] args) {

        CarRepository carRepository = new CarRepositoryFileImpl();
        Garage garage = ((CarRepositoryFileImpl) carRepository).getGarage();

        //Добавление машин в гараж
        carRepository.allCarInGarage();
        carRepository.allPerformanceCarInGarage();
        carRepository.allShowCarInGarage();

        //работа в гараже
        garage.modificateCar(3);
        System.out.println(garage.showCar(3));

        System.out.println("");
        garage.modificateCar(7);
        System.out.println(garage.showCar(7));

        //вывод всех машин в гараже в файл
        carRepository.writeListCarsInFile();

    }
}
