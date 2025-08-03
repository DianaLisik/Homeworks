package homework.homework07;

public class AppAddition {
    public static void main(String[] args) {

        Product milk = new Product("Молоко", 200);
        Product cake = new DiscountProduct("Торт", 800, 30, true);
        Product beer = new Product("Пиво", 150, true);


        Person vasya = Person.came("Василий", 500, 34);
        vasya.addProduct(cake);

        Person petya = Person.came("Петр Сергеевич", 500, 70);
        petya.addProduct(milk);

        Person lesha = Person.came("Леша", 500, 10);
        lesha.addProduct(milk);
        lesha.addProduct(beer);

        Person kolya = Person.came("Коля", 500, 5);
        kolya.addProduct(milk);


        System.out.println(vasya.toString());
        System.out.println(petya.toString());
        System.out.println(lesha.toString());
        System.out.println(kolya.toString());
    }
}
