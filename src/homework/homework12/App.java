package homework.homework12;

import homework.homework12.exception.PhoneNumberFormatException;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Вводите персонажей в формате " +
                "\nФамилия Имя Отчество датарождения номертелефона пол возраст");
        try {
            while (true) {
                String line = scanner.nextLine();
                if (line.equals("end")) break;
                new Person(line);
            }
        } catch (PhoneNumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
