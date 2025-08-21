package homework.homework09;

import homework.homework09.car.Car;
import homework.homework09.car.PerformanceCar;
import homework.homework09.car.ShowCar;
import homework.homework09.file.File;

public class App {
    public static void main(String[] args) {

        Garage garage = new Garage();

        String params;
        while ((params = File.carFile()) != null) {
            garage.addCar(Car.inGarage(params));
        }
        while ((params = File.performanceCarFile()) != null) {
            garage.addCar(PerformanceCar.inGarage(params));
        }
        while ((params = File.showCarFile()) != null) {
            garage.addCar(ShowCar.inGarage(params));
        }

        garage.modificateCar(4);
        System.out.println(garage.showCar(4));

        garage.modificateCar(7);
        System.out.println(garage.showCar(7));


        File.outputFile("Все авто стоящие в гараже");
        for (Car element : garage.getParkedCars()) {
            File.outputFile(element.toString());
        }

    }
}
