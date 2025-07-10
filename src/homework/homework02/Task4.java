package homework.homework02;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число строк и столбцов сетки: ");
        int inputInt = scanner.nextInt();
        System.out.print("Введите повторяемый элемент сетки: ");
        String inputChar = scanner.next();

        System.out.println("Сетка по запросу " + inputInt + " на " + inputInt);
        for (int i = 0; i < inputInt; i++) {
            System.out.println(inputChar.repeat(inputInt));
        }
    }
}
