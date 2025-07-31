package homework.homework07;

import java.util.Objects;

public class Product {
    private String name;
    private long cost;

    public Product(String name, long cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            if (name.matches("\\d+")) throw new IllegalArgumentException("Недопустимая стоимость продукта!\n" +
                    "Имя не может содержать только цифры");
            if (name.length() <= 3) throw new IllegalArgumentException("Недопустимая стоимость продукта!\n" +
                    "Имя из 3-х символов недопустимо");
            this.name = name;
        } else {
//            System.out.println("Имя не может быть пустым");
//            System.exit(0);
            throw new IllegalArgumentException("Недопустимая стоимость продукта!\n" +
                    "Имя не может быть пустым");
        }
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        if (cost > 0) {
            this.cost = cost;
        } else {
//            System.out.println("Деньги не могут быть отрицательными");
//            System.exit(0);
            throw new IllegalArgumentException("Недопустимая стоимость продукта!\n" +
                    "Деньги не могут быть отрицательными");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
