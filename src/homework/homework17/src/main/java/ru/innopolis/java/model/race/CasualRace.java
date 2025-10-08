package ru.innopolis.java.model.race;

import ru.innopolis.java.model.car.Car;

//обычная гонка
public class CasualRace extends Race {
    public CasualRace(int distance, String route, int prizeFund, Car[] member) {
        super(distance, route, prizeFund, member);
    }
}
