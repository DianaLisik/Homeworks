package homework.homework07;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

//        Product product = new Product("coff",102);
//        DiscountProduct milk = new DiscountProduct("milk",80,10,true);
//
//        Person person = new Person("Vasay",1000);
//
//        person.addProduct(product);
//        person.addProduct(milk);
//
//        System.out.println(milk);


        Scanner scanner = new Scanner(System.in);

        List<Product> listProduct = new ArrayList<>();

        System.out.println("Введите продукты в формате Продукт = Цена, Скидка%");
        while (true) {
            String inputLine = scanner.nextLine();
            String[] inputProduct;
            if (inputLine.equals("END")) {
                break;
            } else {
                inputProduct = inputLine.split("( = )|(, )|(%)");
            }
            switch (inputProduct.length) {
                case 2:
                    listProduct.add(new Product(inputProduct[0], Long.parseLong(inputProduct[1])));
                    break;
                case 3:
                    listProduct.add(new DiscountProduct(inputProduct[0], Long.parseLong(inputProduct[1]),
                            Integer.parseInt(inputProduct[2]), true));
                    break;
            }
        }

        String commonProducts = "Обычные продукты: ";
        String actionProducts = "Акционные продукты: ";
        for (Product element : listProduct) {
            if (element instanceof DiscountProduct)
                actionProducts += element + ", ";
            else commonProducts += element + ", ";
        }

        System.out.println(commonProducts.substring(0, commonProducts.length() - 2) +
                '\n' + actionProducts.substring(0, actionProducts.length() - 2));

    }
}
