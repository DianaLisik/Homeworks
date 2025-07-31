package homework.homework07;

import java.util.ArrayList;
import java.util.Objects;

public class Person {

    private String name;
    private long money;
    ArrayList<Product> products = new ArrayList<>();
    private boolean male; //пол - мужчина

    public Person(String name, long money) {
        this.setName(name);
        this.setMoney(money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
            this.male = true;
            if (name.charAt(name.length() - 1) == 'а') this.male = false;
        } else {
//            System.out.println("Имя не может быть пустым");
//            System.exit(0);
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        if (money >= 0) {
            this.money = money;
        } else {
            System.out.println("Деньги не могут быть отрицательными");
            System.exit(0);
//            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        long costProduct = product.getCost();
        if (product instanceof DiscountProduct) {
            if (((DiscountProduct) product).isDiscountIsOn()) {
                DiscountProduct discountProduct = (DiscountProduct) product;
                costProduct = discountProduct.getCost() * (100 - discountProduct.getDiscount()) / 100;
            }
        }

        if (money >= costProduct) {
            this.products.add(product);
            this.money -= costProduct;
            String str = (male) ? this.name + " купил " + product.getName() :
                    this.name + " купила " + product.getName();
            System.out.println(str);
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());
        }
    }

//    public void addProduct(DiscountProduct product) {
//        long newCost = product.getCost() * (100 - product.getDiscount()) / 100;
//        if (money >= newCost) {
//            this.products.add(product);
//            this.money -= newCost;
//            String str = (male) ? this.name + " купил " + product.getName() :
//                    this.name + " купила " + product.getName();
//            System.out.println(str);
//        } else {
//            System.out.println(name + " не может позволить себе " + product.getName());
//        }
//    }

    @Override
    public String toString() {
        String output = "";
        if (products.isEmpty()) return name + " - Ничего не куплено";
        for (Product el : products) {
            output += el.getName() + ", ";
        }
        return name + " - " + output.substring(0, output.length() - 2);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
