package homework.homework10;

import java.util.Arrays;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {

        int[] array = {10, 24, 5, 33, 6, 8, 3};

//        Function<Integer, Boolean> condition = number -> number % 2 == 0;

        ByCondition condition = number -> number % 2 == 0;

        int[] result = Sequence.filter(array, condition);

        ByCondition condition2 = number -> {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum % 2 == 0;
        };

        int[] result2 = Sequence.filter(array, condition2);

        System.out.println("Исходный массив - " + Arrays.toString(array));
        System.out.println("Четные элементы - " + Arrays.toString(result));
        System.out.println("Четная сумма элементов - " + Arrays.toString(result2));

    }
}
