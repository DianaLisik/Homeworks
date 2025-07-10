package homework.homework03;

public class TV {

    private String brand;
    private String model;
    private int diagonal;
    private String typeScreen;
    private String smartTV;
    private boolean include; //работает или выкл
    private int noise = 0; // звук

    //Конструкторы
//    public TV(){}

    public TV(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public TV(String brand, String model, int diagonal, String typeScreen, String smartTV) {
        this.brand = brand;
        this.model = model;
        this.diagonal = diagonal;
        this.typeScreen = typeScreen;
        this.smartTV = smartTV;
        this.include = false;
        this.noise = 0;
    }

    public TV(String brand, String model, int diagonal, String typeScreen, String smartTV, boolean include, int noise) {
        this.brand = brand;
        this.model = model;
        this.diagonal = diagonal;
        this.typeScreen = typeScreen;
        this.smartTV = smartTV;
        this.include = include;
        this.noise = noise;
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
                '}';
    }
}
