package homework.homework08.Person;

import homework.homework08.Product.Product;

public class Children extends Person {
    public Children(String name, long money, int age) {
        super(name, money, age);
        System.out.println("На кассе Дети");
    }

    @Override
    public void addProduct(Product product) {
        if (super.getAge() <= 6) System.out.println("Ребенок не может купить товар");
        else super.addProduct(product);
    }
}
