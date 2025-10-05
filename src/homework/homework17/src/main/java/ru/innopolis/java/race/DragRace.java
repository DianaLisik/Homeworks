package ru.innopolis.java.race;

import ru.innopolis.java.car.Car;

//гонка за самый мощный двигатель. Идеальное переключение передач — залог победы.

public class DragRace extends Race{
    public DragRace(int distance, String route, int prizeFund, Car[] member) {
        super(distance, route, prizeFund, member);
    }
}
