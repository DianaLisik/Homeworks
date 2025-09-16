package homeworks.homework14;

import homework.homework06.App;
import homework.homework06.Person;
import homework.homework06.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

public class App_6Test {

    @Test
    void getInputPersonsFromLine() {
        String line = "Павел Андреевич = 10000, Анна Петровна = 2000, Борис = 10";
        Person[] listPerson = App.getPersonsFromLine(line);

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(listPerson);
            Assertions.assertEquals(new Person("Павел Андреевич", 10000), listPerson[0]);
            Assertions.assertEquals(new Person("Анна Петровна", 2000), listPerson[1]);
            Assertions.assertEquals(new Person("Борис", 10), listPerson[2]);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"Анна Петровна = двеТыщи", "", "Павел Андреевич 100"})
    void getInputPersonsFromLineError(String line) {
        Exception exception = Assertions.assertThrows(Exception.class, () -> App.getPersonsFromLine(line));
        if (exception instanceof NumberFormatException || exception instanceof ArrayIndexOutOfBoundsException) {
            Assertions.assertTrue(true);
        } else Assertions.assertTrue(false);
    }

    //Проигнорировать один из тестов
    void getInputProductFromLine() {
        String line = "Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 879; Масло = 150";
        ArrayList<Product> listProduct = App.getProductFromLine(line);
        Assertions.assertAll(() -> {
            Assertions.assertNotNull(listProduct);
            Assertions.assertEquals(new Product("Хлеб", 40), listProduct.get(0));
            Assertions.assertEquals(new Product("Молоко", 60), listProduct.get(1));
            Assertions.assertEquals(new Product("Торт", 1000), listProduct.get(2));
            Assertions.assertEquals(new Product("Кофе растворимый", 879), listProduct.get(3));
            Assertions.assertEquals(new Product("Масло", 150), listProduct.get(4));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"Хлеб = сорок", "", "Молоко 100"})
    void getInputProductFromLineError(String line) {
        Exception exception = Assertions.assertThrows(Exception.class, () -> App.getProductFromLine(line));
        if (exception instanceof NumberFormatException || exception instanceof ArrayIndexOutOfBoundsException) {
            Assertions.assertTrue(true);
        } else Assertions.assertTrue(false);
    }

}
