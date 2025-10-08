package ru.innopolis.java.model.car;

import lombok.*;

//Базовый автомобиль
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Car {

    private String brand;
    private String model;
    private int age;
    private int power; //мощьность
    private int speed;
    private int clearance; //подвеска (растояние от дна машины до дороги)
    private int durability; //долговечность


    public static Car inGarage(String params) {
        String[] param = params.split(", ");
        Car car = new Car(param[0], param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                Integer.parseInt(param[4]), Integer.parseInt(param[5]), Integer.parseInt(param[6]));
        return car;
    }

    @Override
    public String toString() {
        return "авто: Модель " + brand + " " + model + ", год " + age +
                ", мощьность " + power + "л.с., скорость " + speed + "км/ч, подвеска " + clearance +
                ", долговечность " + durability + "т.км";
    }
}
