package attestation.attestation01;

import attestation.attestation01.exception.UserNotFoundException;
import attestation.attestation01.model.User;
import attestation.attestation01.repositories.UsersRepository;
import attestation.attestation01.repositories.impl.UsersRepositoryFileImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UsersRepositoryFileImpl_test {

    private UsersRepository usersRepository;
    private String PATH = "test/attestation/attestation01/";

    @BeforeEach
    void init() {

        usersRepository = new UsersRepositoryFileImpl(PATH + "input.txt");

        Path sourceFile = Paths.get(PATH + "input.txt");
        Path destinationFile = Paths.get(PATH + "input_2.txt");

        try {
            // Копирование файла с заменой, если он существует
            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл успешно скопирован!");
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void createUserInDB() {
        User user = new User("noisemc_99", "789ghs", "789ghs", "Крылов", "Виктор");
        usersRepository.create(user);

        String file1Path = PATH + "input.txt";
        String file2Path = PATH + "input_2.txt";

        byte[] bytes1;
        byte[] bytes2;
        try {
            bytes1 = Files.readAllBytes(Paths.get(file1Path));
            bytes2 = Files.readAllBytes(Paths.get(file2Path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertAll(() -> {
            Assertions.assertTrue(bytes1.length != 0); //файл не пуст
            Assertions.assertFalse(bytes1.equals(bytes2));//в файле было изменение
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "noisemc_99|123Qwer|789ghs|Крылов|Виктор", //разные пароли
            "noisemc_99|32545dfg|789ghs|Крылов|Виктор|Антонович", //недопустимое количество параметров
            "235143436|32545dfg|32545dfg|Крылов|Виктор", // логин только цифры
            "noisemc_991|qwer|qwer|Крылов|Виктор|"})  // пароль только из букв
    void createUserError(String line) {
        String[] params = line.split("//|");
        Exception exception = Assertions.assertThrows(Exception.class, () ->
                usersRepository.create(new User(params[0], params[1], params[2], params[3], params[4])));
    }

    @Test
    void getUserFromFindById() {
        usersRepository.create(new User("c1d463be-4bfb-409a-adeb-d2642d45080c|2024-07-20T21:15:13.036817|" +
                "PupicSV777|123saFSqwe|123saFSqwe|Пупочкин|Вася|null|0|false"));
        usersRepository.create(new User("d6474bd8-f228-475f-92e1-2e9bca058d32|2025-09-20T21:18:13.036817|" +
                "ComFeDs_008|uYUhbj_92f|uYUhbj_92f|Максимов|Илья|Антонович|25|true"));
        User user = usersRepository.findById("c1d463be-4bfb-409a-adeb-d2642d45080c");

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(user);
            Assertions.assertEquals("Пупочкин", user.getFirstName());
            Assertions.assertEquals("Вася", user.getName());
            Assertions.assertEquals("PupicSV777", user.getLogin());
            Assertions.assertEquals(false, user.isWorker());
        });
    }

    @Test
    void getUserFromFindByIdError() {
        Exception exception = Assertions.assertThrows(UserNotFoundException.class, () ->
                usersRepository.findById("No_id"));
    }
}
