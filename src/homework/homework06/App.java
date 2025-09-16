package homework.homework06;

import java.util.*;

public class App {
    private static Person[] listPerson;
    private static ArrayList<Product> listProduct;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        String persons = "Павел Андреевич = 10000, Анна Петровна = 2000, Борис = 10";
//        String products = "Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 879; Масло = 150";

        System.out.println("Введите покупателей в формате [покупатель = деньги, ...]");
        listPerson = getPersonsFromLine(scanner.nextLine());
        System.out.println("Введите товары в формате [товар = деньги; ...]");
        listProduct = getProductFromLine(scanner.nextLine());

        System.out.println("Работа на кассе. Вводите в формате [покупатель - товар]. \nПо завершению введите [END]");
        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine.equals("END")) {
                break;
            } else {
                addProductInPerson(inputLine);
            }
        }
        writeListOfPeople();
    }

    public static Person[] getPersonsFromLine(String personsLine){
        Person[] persons = new Person[10];
        String[] myArrayPersons = personsLine.split("( = )|(, )");
        for (int i = 0, j = 0; i < myArrayPersons.length; i += 2, j++) {
            persons[j] = new Person(myArrayPersons[i], Integer.parseInt(myArrayPersons[i + 1]));
        }
        return persons;
    }

    public static  ArrayList<Product> getProductFromLine(String productLine){
        ArrayList<Product> products = new ArrayList<>();
        String[] myArrayProducts = productLine.split("( = )|(; )");
        for (int i = 0; i < myArrayProducts.length; i += 2) {
            products.add(new Product(myArrayProducts[i], Integer.parseInt(myArrayProducts[i + 1])));
        }
        return products;
    }

    public static void addProductInPerson (String line) {
        String[] personProduct = line.split("( - )");
        int indexPerson = 0;
        int indexProduct = listProduct.indexOf(new Product(personProduct[1]));

        for (int i = 0; i < listPerson.length - 1; i++) {
            if (listPerson[i].getName().equals(personProduct[0])) {
                indexPerson = i;
                break;
            }
        }

        listPerson[indexPerson].addProduct(listProduct.get(indexProduct));
    }

    public static void writeListOfPeople() {
        for (Person element : listPerson) {
            if (element == null) break;
            System.out.println(element.toString());
        }
    }
}
