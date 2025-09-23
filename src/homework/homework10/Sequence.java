package homework.homework10;

import java.util.Arrays;

public class Sequence {

    public static int[] filter(int[] array, ByCondition condition) {
        int[] result = new int[0];
        int j = 0;
        for (int element : array) {
            if (condition.isOk(element)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[j] = element;
                j++;
            }
        }
        return result;
    }
}
