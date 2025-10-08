package ru.innopolis.java.model.car;

import lombok.*;

//спортивная машина
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode (callSuper = false)
public class ShowCar extends Car {

    private int stars = 0;

    public ShowCar(String brand, String model, int age, int power, int speed,
                   int clearance, int durability, int stars) {
        super(brand, model, age, power, speed, clearance, durability);
        this.stars = stars;
    }

    public static ShowCar inGarage(String params) {
        String[] param = params.split(", ");
        int stars = (param.length == 8) ? Integer.parseInt(param[7]) : 0;
        ShowCar car = new ShowCar(param[0], param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                Integer.parseInt(param[4]), Integer.parseInt(param[5]), Integer.parseInt(param[6]), stars);
        return car;
    }

    @Override
    public String toString() {
        return "спортивное " + super.toString() + " оценка: " + stars;
    }
}
