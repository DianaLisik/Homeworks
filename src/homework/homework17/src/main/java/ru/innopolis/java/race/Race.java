package ru.innopolis.java.race;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.innopolis.java.car.Car;

@AllArgsConstructor
@Getter
@Setter
public abstract class Race {

    private int distance;
    private String route;
    private int prizeFund;
    private Car[] member;


}
