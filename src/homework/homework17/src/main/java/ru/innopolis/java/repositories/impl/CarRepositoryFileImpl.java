package ru.innopolis.java.repositories.impl;

import lombok.NoArgsConstructor;
import ru.innopolis.java.Garage;
import ru.innopolis.java.model.car.Car;
import ru.innopolis.java.model.car.PerformanceCar;
import ru.innopolis.java.model.car.ShowCar;
import ru.innopolis.java.repositories.CarRepository;

import java.io.*;

@NoArgsConstructor
public class CarRepositoryFileImpl implements CarRepository {

    private Garage garage = new Garage();
    private static String PATH = "src/homework/homework17/src/main/java/ru/innopolis/java/file/";

    public CarRepositoryFileImpl(String path) {
        PATH = path;
    }

    @Override
    public void writeListCarsInFile() {
        String path = "src/homework/homework17/src/main/resources/";
        writeListCarsInFile(path);
    }

    public void writeListCarsInFile(String path) {
        PATH = path;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH+ "output.txt"))) {
            bufferedWriter.write("Все авто стоящие в гараже");
            bufferedWriter.newLine();
            for (Car element : garage.getParkedCars()) {
                bufferedWriter.write(element.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void allCarInGarage() {
        try (BufferedReader carReader = new BufferedReader(new FileReader(PATH + "car.txt"))) {
            String params;
            while ((params = carReader.readLine()) != null) {
                garage.addCar(Car.inGarage(params));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void allPerformanceCarInGarage() {
        try (BufferedReader carReader = new BufferedReader(new FileReader(PATH + "performanceCar.txt"))) {
            String params;
            while ((params = carReader.readLine()) != null) {
                garage.addCar(PerformanceCar.inGarage(params));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void allShowCarInGarage() {
        try (BufferedReader carReader = new BufferedReader(new FileReader(PATH + "showCar.txt"))) {
            String params;
            while ((params = carReader.readLine()) != null) {
                garage.addCar(ShowCar.inGarage(params));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Garage getGarage() {
        return garage;
    }
}
