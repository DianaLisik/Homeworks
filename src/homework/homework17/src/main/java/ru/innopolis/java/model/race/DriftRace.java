package ru.innopolis.java.model.race;

import ru.innopolis.java.model.car.Car;

//дрифтовая гонка
public class DriftRace extends Race{
    public DriftRace(int distance, String route, int prizeFund, Car[] member) {
        super(distance, route, prizeFund, member);
    }
}
