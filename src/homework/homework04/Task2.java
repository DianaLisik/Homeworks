package homework.homework04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите строку из символов < > - ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.length() > 106) {
            input = input.substring(0, 106);
        }

        Pattern pattern1 = Pattern.compile("(?:>>-->)|(?:<--<<)");

        Matcher matcher1 = pattern1.matcher(input);
        int counter = 0;
        while (matcher1.find()) {
            counter++;
        }
        System.out.println("Всего было совпадений - " + counter);
    }
}
