package homework.homework11;

import java.util.Objects;

public class Car {

    private String number;
    private String model;
    private String color;
    private int mileage; //пробег
    private int price;

    public Car() {
    }

    public Car(String number, String model, String color, int mileage, int price) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public Car(String params) {
        String[] param = params.split("\\|");
        this.number = param[0];
        this.model = param[1];
        this.color = param[2];
        this.mileage = Integer.parseInt(param[3]);
        this.price = Integer.parseInt(param[4]);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage && price == car.price && Objects.equals(number, car.number) && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, color, mileage, price);
    }

    @Override
    public String toString() {
        return number + "  " + model + "  " + color + "  " + mileage + "  " + price;
    }
}
