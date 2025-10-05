package ru.innopolis.java.car;


import lombok.*;

import java.util.Arrays;
import java.util.Objects;

//гоночный автомобиль
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode (callSuper = false)
public class PerformanceCar extends Car {

    private String[] addons;


    public PerformanceCar(String brand, String model, int age, int power, int speed, int clearance,
                          int durability, String[] addons) {
        super(brand, model, age, power, speed, clearance, durability);
        this.addons = addons;
    }


    public static PerformanceCar inGarage(String params) {
        String[] param = params.split(", ");
        String[] str = new String[param.length - 7];
        for (int j = 0, i = 7; i < param.length; j++, i++) {
            str[j] = param[i];
        }
        PerformanceCar car = new PerformanceCar(param[0], param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                Integer.parseInt(param[4]), Integer.parseInt(param[5]), Integer.parseInt(param[6]), str);
        return car;
    }

    public void addAddons(String newAddons) {
        this.addons = Arrays.copyOf(addons, addons.length + 1);
        addons[addons.length - 1] = newAddons;
    }

    @Override
    public void setPower(int power) {
        super.setPower((int) (power * 1.5));
    }

    @Override
    public void setClearance(int clearance) {
        super.setClearance((int) (clearance * 0.75));
    }

    @Override
    public String toString() {
        return "гоночное " + super.toString() + " \nДополнительно: " + Arrays.toString(addons);
    }
}
