package ru.innopolis.java;


import ru.innopolis.java.car.Car;
import ru.innopolis.java.car.PerformanceCar;
import ru.innopolis.java.car.ShowCar;
import ru.innopolis.java.file.File;
import ru.innopolis.java.race.CasualRace;
import ru.innopolis.java.race.DragRace;
import ru.innopolis.java.race.Race;

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

        garage.modificateCar(3);
        System.out.println(garage.showCar(3));

        System.out.println("");
        garage.modificateCar(7);
        System.out.println(garage.showCar(7));


        File.outputFile("Все авто стоящие в гараже");
        for (Car element : garage.getParkedCars()) {
            File.outputFile(element.toString());
        }

    }
}
