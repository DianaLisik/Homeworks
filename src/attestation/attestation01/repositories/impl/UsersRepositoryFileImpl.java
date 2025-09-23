package attestation.attestation01.repositories.impl;

import attestation.attestation01.exception.UserNotFoundException;
import attestation.attestation01.model.User;
import attestation.attestation01.repositories.UsersRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository {
    private List<User> USERS = new ArrayList<>();
    private String PATH = "src/attestation/attestation01/file/input.txt";

    public UsersRepositoryFileImpl() {
        readFile();
    }

    public UsersRepositoryFileImpl(String path) {
        PATH = path;
        readFile();
    }

    @Override
    public void create(User user) {
        USERS.add(user);
        writeUsersToFile(user);
    }

    @Override
    public User findById(String id) {
        return USERS.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

    @Override
    public List<User> findAll() {
        return USERS;
    }

    @Override
    public void update(User user) {
        try {
            User foudedUser = USERS.stream()
                    .filter(e -> e.getId().equals(user.getId()))
                    .findFirst()
                    .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));

            foudedUser.update(user);
            writeUsersToFile();

        } catch (UserNotFoundException e) {
            System.out.println("Такого пользователя нет в базе. Мы его сохранили");
            create(user);
        }
    }

    @Override
    public void deleteById(String id) {
        USERS.removeIf(user -> user.getId().equals(id));
        writeUsersToFile();
    }

    @Override
    public void deleteAll() {
        USERS.clear();
        writeUsersToFile();
    }

    private void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                USERS.add(new User(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Файл не найден: " + e.getMessage());
        }
    }

    private void writeUsersToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH))) {
            for (User el : USERS) {
                bufferedWriter.write(el.toString());
                bufferedWriter.flush();
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private void writeUsersToFile(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH, true))) {
            if (USERS.size() != 1) bufferedWriter.newLine();//файл изначально был пуст
            bufferedWriter.write(user.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}