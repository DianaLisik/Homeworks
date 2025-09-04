package homework.homework11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/homework/homework11/input.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/homework/homework11/output.txt"))) {

            List<Car> listCar = new ArrayList<>();

            String params;
            bufferedReader.readLine(); //пропуск 1ой строчки
            while ((params = bufferedReader.readLine()) != null) {
                listCar.add(new Car(params));
            }

            bufferedWriter.write("Автомобили в базе:");
            bufferedWriter.newLine();
            bufferedWriter.write("Number Model Color Mileage Cost");
            for (Car el : listCar) {
                bufferedWriter.newLine();
                bufferedWriter.write(el.toString());
            }

            bufferedWriter.newLine();
            List str = listCar.stream()
                    .filter(e -> e.getColor().equals("Black") || e.getMileage() == 0)
                    .map(Car::getNumber)
                    .toList();
            bufferedWriter.newLine();
            bufferedWriter.write("Номера автомобилей по цвету или пробегу: " + str);


            int n = 700000, m = 800000;
            bufferedWriter.newLine();
            bufferedWriter.write("Уникальные автомобили:" +
                    listCar.stream()
                            .filter(e -> e.getPrice() > n && e.getPrice() < m)
                            .map(Car::getModel)
                            .distinct()
                            .count());

            bufferedWriter.newLine();
            bufferedWriter.write("Цвет автомобиля с минимальной стоимостью: " +
                    listCar.stream()
                            .min((e1, e2) -> Integer.compare(e1.getPrice(), e2.getPrice()))
                            .map(Car::getColor)
                            .get());

            bufferedWriter.newLine();
            bufferedWriter.write("Средняя стоимость модели Toyota: " +
                    listCar.stream()
                            .filter(e -> e.getModel().equals("Toyota"))
                            .mapToDouble(Car::getPrice)
                            .average()
                            .orElse(0));

            bufferedWriter.newLine();
            bufferedWriter.write("Средняя стоимость модели Volvo: " +
                    listCar.stream()
                            .filter(e -> e.getModel().equals("Volvo"))
                            .mapToDouble(Car::getPrice)
                            .average()
                            .orElse(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
