package homework.homework03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        TV samsung = new TV("Samsung","QN90A",65,"QLED","Tizen");
        TV lg = new TV("LG","OLED65C1",65,"OLED", "webOS",true,33);
        System.out.println(samsung);
        System.out.println(lg);

        samsung.onTv();
        samsung.changeNoise(78);
        lg.offTv();

        System.out.println(samsung);
        System.out.println(lg);

        System.out.println("Введите новый телевизор в формате:");
        System.out.println("Бренд Модель Диаганаль ТипЭкрана SmartTV(название ОС)");
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();
        String[] myArray = myString.split(" ");

        TV newTv = new TV(myArray[0], myArray[1],Integer.parseInt(myArray[2]), myArray[3], myArray[4]);
        System.out.println(newTv);
    }
}
