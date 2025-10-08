import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.innopolis.java.Garage;
import ru.innopolis.java.model.car.Car;
import ru.innopolis.java.repositories.CarRepository;
import ru.innopolis.java.repositories.impl.CarRepositoryFileImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CarRepositoryTest {
    private CarRepository carRepository;
    private String PATH = "src/test/java/resources/";
    private Garage garage;

    @BeforeEach
    void init() {
        carRepository = new CarRepositoryFileImpl(PATH);
        garage = ((CarRepositoryFileImpl) carRepository).getGarage();

        try (FileWriter writer = new FileWriter(PATH + "output.txt")) {
            writer.write("");
        } catch (IOException e) {
            System.err.println("Произошла ошибка при очистке файла: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void readCarFromFile() {

        carRepository.allCarInGarage();
        List<Car> parkedCars = garage.getParkedCars();

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(parkedCars);
            Assertions.assertTrue(parkedCars.size() != 0);//В списке гаража есть машины
        });
    }

    @Test
    void readCarFromFileError() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () ->
                carRepository.allShowCarInGarage());
    }

    @Test
    void writeCarInFile() {
        carRepository.allCarInGarage();
        ((CarRepositoryFileImpl) carRepository).writeListCarsInFile(PATH);

        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Paths.get(PATH + "output.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertAll(() -> {
            Assertions.assertTrue(bytes.length != 0); //файл не пуст, были записи
        });
    }
}
