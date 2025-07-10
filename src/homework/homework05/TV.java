package homework.homework05;

import java.util.Objects;

public class TV {

    private String brand;
    private String model;
    private int diagonal;
    private String typeScreen;
    private String smartTV;
    private boolean include; //работает или выкл
    private int noise = 0; // звук
    private int channel;
    static int CountTV;

    //Конструкторы
//    public TV(TV.CountTV++;){}

    public TV(String model, String brand) {
        this.model = model;
        this.brand = brand;
        TV.CountTV++;
    }

    public TV(String brand, String model, int diagonal, String typeScreen, String smartTV) {
        this.brand = brand;
        this.model = model;
        this.diagonal = diagonal;
        this.typeScreen = typeScreen;
        this.smartTV = smartTV;
        this.include = false;
        this.noise = 0;
        TV.CountTV++;
    }

    public TV(String brand, String model, int diagonal, String typeScreen, String smartTV, boolean include, int noise, int channel) {
        this.brand = brand;
        this.model = model;
        this.diagonal = diagonal;
        this.typeScreen = typeScreen;
        this.smartTV = smartTV;
        this.include = include;
        this.noise = noise;
        this.channel = channel;
        TV.CountTV++;
    }

    //Методы
    public void onTv() {
        this.include = true;
        System.out.println(String.format("Телевизор %s %s включен", this.brand, this.model));
    }

    public void offTv() {
        this.include = false;
        System.out.println(String.format("Телевизор %s %s выключен", this.brand, this.model));
    }

    public void changeNoise(int noise) {
        if (this.include && noise >= 0 && noise <= 100) {
            this.noise = noise;
        } else if (!this.include) {
            System.out.println("Сначало надо включить телевизор");
        } else {
            System.out.println("Звук может быть в пределах от 0 до 100");
        }

    }

    public TV changSmartTV(String newSmartTv) {
        this.smartTV = newSmartTv;
        return this;
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

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public String getTypeScreen() {
        return typeScreen;
    }

    public void setTypeScreen(String typeScreen) {
        this.typeScreen = typeScreen;
    }

    public boolean isInclude() {
        return include;
    }

    public void setInclude(boolean include) {
        this.include = include;
    }

    public int getNoise() {
        return noise;
    }

    public String getSmartTV() {
        return smartTV;
    }

    public void setSmartTV(String smartTV) {
        this.smartTV = smartTV;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "TV{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", diagonal=" + diagonal +
                ", typeScreen='" + typeScreen + '\'' +
                ", smartTV='" + smartTV + '\'' +
                ", include=" + include +
                ", noise=" + noise +
                ", channel=" + channel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return diagonal == tv.diagonal && include == tv.include && noise == tv.noise && channel == tv.channel &&
                Objects.equals(brand, tv.brand) && Objects.equals(model, tv.model) && Objects.equals(typeScreen,
                tv.typeScreen) && Objects.equals(smartTV, tv.smartTV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, diagonal, typeScreen, smartTV, include, noise, channel);
    }
}
