package homework.homework05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TV[] allTV = new TV[10];
        allTV[0] = new TV("Samsung", "QN90A", 65, "QLED", "Tizen", true, 0, 45);
        allTV[1] = new TV("LG", "OLED65C1", 65, "OLED", "webOS", true, 33, 45);
        allTV[2] = new TV("Sony", "KD55X", 65, "LED", "Android TV", true, 56, 3);
        allTV[3] = new TV("Philips", "55OLED", 65, "OLED", "Android TV", false, 34, 8);
        allTV[4] = new TV("Xiaomi", "MiTV4S", 65, "LED", "Android TV", true, 90, 67);
        allTV[5] = new TV("Hisense", "55U8QF", 65, "ULED", "VIDAA U", true, 45, 47);
        allTV[6] = new TV("TCL", "65C815", 65, "QLED", "Android TV", false, 13, 33);
        allTV[7] = new TV("Samsung", "UE43TU", 65, "LED", "Tizen", true, 36, 135);
        allTV[8] = new TV("LG", "43UN7", 65, "LED", "webOS", true, 76, 22);
        allTV[9] = new TV("Sony", "KD", 65, "LED", "Android TV", false, 90, 24);

        System.out.println("Введите мах допустимую громкасть");
        int maxVolume = scanner.nextInt();

        System.out.println("Список включенных телевизоров с допустимой громкостью: ");
        for (int i = 0; i < allTV.length; i++) {
            if (allTV[i].isInclude() && allTV[i].getNoise() <= maxVolume) {
                System.out.println(allTV[i]);
            }
        }


        Arrays.sort(allTV, Comparator.comparingInt(o -> o.getChannel()));

        System.out.println("Отсортированные телевизоры по каналу: ");
        for (int i = 0; i < allTV.length; i++) {
            System.out.println(allTV[i].getBrand() + " " + allTV[i].getModel() + " канал - " + allTV[i].getChannel());
        }

    }
}
