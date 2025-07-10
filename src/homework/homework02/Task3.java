package homework.homework02;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Исходная строка:");
        String inputString = scanner.next();
        System.out.print("Сколько раз вывести строку? ");
        int inputInt = scanner.nextInt();

        System.out.println("После повторения " + inputInt + " раз: " + inputString.repeat(inputInt));
    }
}
