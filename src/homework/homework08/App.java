package homework.homework08;

import homework.homework08.File.File;
import homework.homework08.Person.*;
import homework.homework08.Product.Product;

import java.util.ArrayList;


public class App {
    public static void main(String[] args) {

        String persons = File.intutFile();
        String products = File.intutFile();

        ArrayList<Person> listPerson = new ArrayList<>();
        ArrayList<Product> listProduct = new ArrayList<>();

        String[] personArray = persons.split(", ");
        for (int i = 0; i < personArray.length; i++) {
            listPerson.add(new Person(personArray[i]));
        }

        String[] productArray = products.split("; ");
        for (int i = 0; i < productArray.length; i++) {
            listProduct.add(new Product(productArray[i]));
        }

        File.outputFile("Работа на кассе");
        while (true) {
            String line = File.intutFile();
            if (line.equals("END")) {
                break;
            }
            String[] inputPersonProduct = line.split("( - )");
            String personName = inputPersonProduct[0];
            String productName = inputPersonProduct[1];

            int indexPerson = listPerson.indexOf(Person.getIndex(personName));
            int indexProduct = listProduct.indexOf(Product.getIndex(productName));

            listPerson.get(indexPerson).addProduct(listProduct.get(indexProduct));

        }

        File.outputFile("");
        for (Person element : listPerson) {
            if (element == null) break;
            File.outputFile(element.toString());
        }
    }
}
