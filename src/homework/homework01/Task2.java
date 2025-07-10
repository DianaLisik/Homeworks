package homework.homework01;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

        Random random = new Random();
        int vasya = random.nextInt(3);
        int petya = random.nextInt(3);

        System.out.println("Вася выбрал " + ((vasya == 0) ? "камень" : ((vasya == 1) ? "ножницы" : "бумагу")));
        System.out.println("Петя выбрал " + ((petya == 0) ? "камень" : ((petya == 1) ? "ножницы" : "бумагу")));


        if (vasya == petya) {
            System.out.println("Ничья");
        } else if ((vasya == 0 && petya == 1) || (vasya == 1 && petya == 2) || (vasya == 2 && petya == 0))
            System.out.println("Вася выйграл");
        else System.out.println("Петя выйграл");

    }
}
