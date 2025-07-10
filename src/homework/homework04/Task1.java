package homework.homework04;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String string = "qwertyuiopasdfghjklzxcvbnm";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите символ с клавиатуры");
        char input = scanner.next().charAt(0);

        char output;
        if (string.indexOf(input) == 0) {
            output = string.charAt(string.length() - 1);
        } else {
            output = string.charAt(string.indexOf(input) - 1);
        }
        System.out.println("Левый символ - " + output);

    }
}
