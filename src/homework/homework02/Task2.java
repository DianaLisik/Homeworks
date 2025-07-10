package homework.homework02;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите 1-е целое число: ");
        int ferst = scanner.nextInt();
        System.out.print("Введите 2-ое целое число: ");
        int second = scanner.nextInt();

        System.out.println("Сумма двух целых чисел: " + Math.addExact(ferst, second));
        System.out.println("Разница двух целых чисел: " + Math.subtractExact(ferst, second));
        System.out.println("Произведение из двух целых чисел: " + Math.multiplyExact(ferst, second));
        System.out.println("Среднее из двух целых чисел: " + (ferst + second) / 2);
        System.out.println("Расстояние двух целых чисел: " + Math.subtractExact(ferst, second));
        System.out.println("Максимальное целое число: " + Math.max(ferst, second));
        System.out.println("Минимальное целое число: " + Math.min(ferst, second));

    }
}
