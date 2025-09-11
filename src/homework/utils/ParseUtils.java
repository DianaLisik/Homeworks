package homework.utils;

public class ParseUtils {

    public static Integer parseCount(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Невалидное значение");
        }
    }

    public static Integer validateCount(String value) {
        try {
            return parseCount(value);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static Double parseNumber(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Невалидное значение");
        }
    }

    public static Double validateNumber(String value) {
        try {
            return parseNumber(value);
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
