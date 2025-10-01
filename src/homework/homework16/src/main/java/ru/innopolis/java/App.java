package ru.innopolis.java;

import ru.innopolis.java.model.User;
import ru.innopolis.java.repositories.UsersRepository;
import ru.innopolis.java.repositories.impl.UsersRepositoryFileImpl;

public class App {
    public static void main(String[] args) {

        UsersRepository usersRepository = new UsersRepositoryFileImpl();

        //Создание пользователя
        User MyUser = new User("login_007", "123saFSqwe", "123saFSqwe", "Андреанов", "Андрей");
        usersRepository.create(MyUser);

        //Выгрузка всех
        for (User el : usersRepository.findAll()) {
            System.out.println(el);
        }

        //поиск по id
        System.out.println();
        System.out.println("Найденный пользователь - " + usersRepository.findById("d50003b8-3041-4610-93ca-485bace338a7"));
        System.out.println();

        //удаление по id
        usersRepository.deleteById("d50003b8-3041-4610-93ca-485bace338a7");
        usersRepository.deleteById("9908c898-2989-4f34-8dff-158fc0a64ee8");
        usersRepository.deleteById("33da4e62-79da-4650-a651-a8281f6af7bb");
        usersRepository.deleteById("cd256576-6dd5-456b-a434-8f2d39cb07b8");

        //Обнавленеи даннных
        MyUser.setAge(33);
        MyUser.setWorker(true);
        usersRepository.update(MyUser);

        System.out.println("После удаление и изменения");
        for (User el : usersRepository.findAll()) {
            System.out.println(el);
        }

        //Удаление всех
        usersRepository.deleteAll();
        System.out.println(usersRepository.findAll());
    }
}

