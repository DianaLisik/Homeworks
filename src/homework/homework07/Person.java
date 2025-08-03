package homework.homework07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Person {

    private String name;
    private long money;
    private int age;
    private boolean takeCredit = false;
    private boolean takeRestrictions = false;
    private Product[] products = new Product[0];
    private boolean male; //пол - мужчина

    public Person(String name, long money, int age) {
        this.setName(name);
        this.setMoney(money);
        this.setAge(age);
    }

    public static Person came(String name, long money, int age) {
        Person person = (age <= 17) ? new Children(name, money, age) :
                ((age > 17 && age < 65) ? new Adult(name, money, age) : new OldPeople(name, money, age));
        return person;
    }

    public String getName() {
        return null;
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
        if (this.takeCredit) {
            this.money = money;
        } else {
            if (money > 0) {
                this.money = money;
            } else {
                System.out.println("Деньги не могут быть отрицательными");
                System.exit(0);
//            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
            }
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не можетт быть отрицательными");
            System.exit(0);
        }
    }

    public boolean isTakeCredit() {
        return takeCredit;
    }

    public void setTakeCredit(boolean takeCredit) {
        this.takeCredit = takeCredit;
    }

    public boolean isTakeRestrictions() {
        return takeRestrictions;
    }

    public void setTakeRestrictions(boolean takeRestrictions) {
        this.takeRestrictions = takeRestrictions;
    }

    public Product[] getProducts() {
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

        if (this instanceof OldPeople) {
            costProduct = costProduct * 95 / 100;
        }

        if (money >= costProduct || takeCredit) {
            if (!product.isRestrictions() || (product.isRestrictions() && ((Person) this).takeRestrictions)) {
                this.products = Arrays.copyOf(products, products.length + 1);
                products[products.length - 1] = product;
                this.money -= costProduct;
                String str = (male) ? this.name + " купил " + product.getName() :
                        this.name + " купила " + product.getName();
                System.out.println(str);
            } else {
                System.out.println(this.name + " не может купить " + product.getName());
            }
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());
        }
    }

    @Override
    public String toString() {
        String output = "";
        if (products.length <= 0) return name + " - Ничего не куплено";
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
