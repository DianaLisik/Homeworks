package homework.homework09.car;

import java.util.Objects;

//спортивная машина
public class ShowCar extends Car {

    private int stars = 0;

    public ShowCar() {
    }

    public ShowCar(String brand, String model, int age, int power, int speed, int clearance, int durability, int stars) {
        super(brand, model, age, power, speed, clearance, durability);
        this.stars = stars;
    }

    public ShowCar(String brand, String model, int age, int power, int speed, int clearance, int durability) {
        super(brand, model, age, power, speed, clearance, durability);
    }

    public static ShowCar inGarage(String params) {
        String[] param = params.split(", ");
        int stars = (param.length == 8) ? Integer.parseInt(param[7]) : 0;
        ShowCar car = new ShowCar(param[0], param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                Integer.parseInt(param[4]), Integer.parseInt(param[5]), Integer.parseInt(param[6]), stars);
        return car;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }

    @Override
    public String toString() {
        return "спортивное " + super.toString() + " оценка: " + stars;
    }
}
