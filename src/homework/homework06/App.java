package homework.homework06;

import java.util.*;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        String persons = "Павел Андреевич = 10000, Анна Петровна = 2000, Борис = 10";
//        String products = "Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 879; Масло = 150";

        System.out.println("Введите покупателей в формате [покупатель = деньги, ...]");
        String persons = scanner.nextLine();
        System.out.println("Введите товары в формате [товар = деньги; ...]");
        String products = scanner.nextLine();


        Person[] person = new Person[10];
        ArrayList<Product> listProduct = new ArrayList<>();

        String[] myArrayPersons = persons.split("( = )|(, )");
        for (int i = 0, j = 0; i < myArrayPersons.length; i += 2, j++) {
            person[j] = new Person(myArrayPersons[i], Integer.parseInt(myArrayPersons[i + 1]));
        }

        String[] myArrayProducts = products.split("( = )|(; )");
        for (int i = 0; i < myArrayProducts.length; i += 2) {
            listProduct.add(new Product(myArrayProducts[i], Integer.parseInt(myArrayProducts[i + 1])));
        }


        System.out.println("Работа на кассе. Вводите в формате [покупатель - товар]. \nПо завершению введите [END]");
        while (true) {
            String inputLine = scanner.nextLine();
            String[] inputPersonProduct;
            if (inputLine.equals("END")) {
                break;
            } else {
                inputPersonProduct = inputLine.split("( - )");
            }

            int indexPerson = 0;
            int indexProduct = listProduct.indexOf(new Product(inputPersonProduct[1]));


            for (int i = 0; i < person.length - 1; i++) {
                if (person[i].getName().equals(inputPersonProduct[0])) {
                    indexPerson = i;
                    break;
                }
            }

            person[indexPerson].addProduct(listProduct.get(indexProduct));
        }

        for (Person element : person) {
            if (element == null) break;
            System.out.println(element.toString());
        }
    }
}
