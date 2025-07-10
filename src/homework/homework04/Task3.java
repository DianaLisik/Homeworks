package homework.homework04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность символов представляющее два слова");
        String input = scanner.nextLine();

        String[] myArray = input.split(" ");

        for (int i = 0; i < myArray.length; i++) {
            char[] chars = myArray[i].toCharArray();
            Arrays.sort(chars); // Осуществляем сортировку массива символов
            myArray[i] = String.valueOf(chars);
        }
        System.out.println("После преобразования - " + Arrays.toString(myArray));

    }
}
