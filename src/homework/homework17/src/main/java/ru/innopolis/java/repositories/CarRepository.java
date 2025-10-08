package ru.innopolis.java.repositories;

public interface CarRepository {

    //Запись всех машин в гараже
    void writeListCarsInFile();

    //Добавление машин из файла в Гараж
    void allCarInGarage();

    void allPerformanceCarInGarage();

    void allShowCarInGarage();

}
