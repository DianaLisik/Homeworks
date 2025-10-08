package ru.innopolis.java;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.innopolis.java.model.car.Car;
import ru.innopolis.java.model.car.PerformanceCar;
import ru.innopolis.java.model.car.ShowCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
@Getter
@Setter
public class Garage {

    public List<Car> parkedCars = new ArrayList<>();

    public String showCar(int carNumber) {
        Car car = parkedCars.get(carNumber);
        return (car.toString());
    }

    public void modificateCar(int carNumber) {
        Car car = parkedCars.get(carNumber);
        System.out.println(car.toString());

        System.out.println("Выберете какой параметр (цифрой) хотите изменить: \n" +
                "1. Мощьность; 2. Скорость; 3. Подвеску; 4. Долговечность " +
                "5.Дополнение(только для гоночных) 6.Популярность(только для спортивных)");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {
            case 1: {
                System.out.print("Введите новое значение мощности: ");
                car.setPower(scanner.nextInt());
                break;
            }
            case 2: {
                System.out.print("Введите новое значение скорости: ");
                car.setSpeed(scanner.nextInt());
                break;
            }
            case 3: {
                System.out.print("Введите новое значение подвески: ");
                car.setClearance(scanner.nextInt());
                break;
            }
            case 4: {
                System.out.print("Введите новое значение долговечности: ");
                car.setDurability(scanner.nextInt());
                break;
            }
            case 5: {
                if (car instanceof PerformanceCar) {
                    System.out.println("Введите новое дополнение: ");
                    String newParam = scanner.nextLine();
                    newParam = scanner.nextLine();
                    ((PerformanceCar) car).addAddons(newParam);
                    break;
                }
            }
            case 6: {
                if (car instanceof ShowCar) {
                    System.out.print("Введите новую оценку: ");
                    int newParam = scanner.nextInt();
                    ((ShowCar) car).setStars(newParam);
                    break;
                }
            }
            default:
                System.out.println("Выбран неверный параметр");
        }
    }

    public void addCar(Car car) {
        parkedCars.add(car);
    }

    public void delCar(Car car) {
        parkedCars.remove(car);
    }

}
