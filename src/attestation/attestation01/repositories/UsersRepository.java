package attestation.attestation01.repositories;

import attestation.attestation01.model.User;

import java.util.List;

public interface UsersRepository {

    void create(User user); //создание пользователя и запись его в файл;

    User findById(String id); // поиск пользователя в файле по идентификатору;

    List<User> findAll(); // выгрузка всех пользователей из файла;

    void update(User user); // обновление полей существующего в файле пользователя;

    void deleteById(String id); // удаление пользователя по идентификатору.

    void deleteAll(); // удаление всех пользователей

}
