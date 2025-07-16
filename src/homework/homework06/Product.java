package homework.homework06;

import java.util.Objects;

public class Product {
    private String name;
    private long cost;

    public Product(String name) {
        this.setName(name);
    }

    public Product(String name, long cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
//            System.out.println("Имя не может быть пустым");
//            System.exit(0);
            throw new IllegalArgumentException("Имя не может быть пустым");
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
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
    }

    @Override
    public String toString() {
        return "Product1{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
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
