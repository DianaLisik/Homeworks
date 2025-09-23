package homework.homework09.car;

import java.util.Objects;

//Базовый автомобиль
public class Car {

    private String brand;
    private String model;
    private int age;
    private int power; //мощьность
    private int speed;
    private int clearance; //подвеска (растояние от дна машины до дороги)
    private int durability; //долговечность

    public Car() {
    }

    public Car(String brand, String model, int age, int power, int speed, int clearance, int durability) {
        this.brand = brand;
        this.model = model;
        this.age = age;
        this.setPower(power);
        this.speed = speed;
        this.setClearance(clearance);
        this.durability = durability;
    }

    public static Car inGarage(String params) {
        String[] param = params.split(", ");
        Car car = new Car(param[0], param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]),
                Integer.parseInt(param[4]), Integer.parseInt(param[5]), Integer.parseInt(param[6]));
        return car;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return age == car.age && power == car.power && speed == car.speed && clearance == car.clearance &&
                durability == car.durability && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, age, power, speed, clearance, durability);
    }

    @Override
    public String toString() {
        return "авто: Модель " + brand + " " + model + ", год " + age +
                ", мощьность " + power + "л.с., скорость " + speed + "км/ч, подвеска " + clearance +
                ", долговечность " + durability + "т.км";
    }
}
