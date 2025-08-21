package homework.homework09;

import homework.homework09.car.Car;
import homework.homework09.car.PerformanceCar;
import homework.homework09.car.ShowCar;

import java.util.*;

public class Garage {

    private List<Car> parkedCars = new ArrayList<>();

    public Garage() {
    }

    public String showCar(int carNumber) {
        Car car = parkedCars.get(carNumber);
        return (car.toString());
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
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
                    System.out.println(newParam);
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
