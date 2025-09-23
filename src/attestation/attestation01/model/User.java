package attestation.attestation01.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class User {
    private String id;
    private LocalDateTime date;
    private String password;
    private String login;
    private String confirmPassword;
    private String firstName;
    private String name;
    private String lastName;
    private int age;
    private boolean isWorker;

    // Паттерны для валидации полей
    private static final Pattern LOGIN_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])([a-zA-Z0-9_]{1,19})$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9_])([a-zA-Z0-9_]{1,19})$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Zа-яА-ЯёЁ]+$"); // Буквы латиницы и кириллицы

    public User(String login, String password, String confirmPassword, String firstName, String name, String lastName, int age) {
        this.id = UUID.randomUUID().toString();
        this.date = LocalDateTime.now();
        setPassword(password);
        setLogin(login);
        setConfirmPassword(confirmPassword);
        setFirstName(firstName);
        setName(name);
        setLastName(lastName);//может не быть
        setAge(age);//может не быть
        this.isWorker = false;
    }

    public User(String login, String password, String confirmPassword, String firstName, String name) {
        this.id = UUID.randomUUID().toString();
        this.date = LocalDateTime.now();
        setPassword(password);
        setLogin(login);
        setConfirmPassword(confirmPassword);
        setFirstName(firstName);
        setName(name);
        this.isWorker = false;
    }

    public User(String inputLine) {
        String[] params = inputLine.split("\\|");
        if (params.length == 10) {
            this.id = params[0];
            this.date = LocalDateTime.parse(params[1]);
            this.login = params[2];
            this.password = params[3];
            this.confirmPassword = params[4];
            this.firstName = params[5];
            this.name = params[6];
            this.lastName = params[7];
            this.age = Integer.parseInt(params[8]);
            this.isWorker = Boolean.parseBoolean(params[9]);
        } else throw new RuntimeException("Неверное количество параметров");
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        if (password.isEmpty()) {
            throw new NullPointerException("Пароль не может быть пустым.");
        }
        if (password.length() >= 20) {
            throw new IllegalArgumentException("Пароль должен быть меньше 20 символов.");
        }
        if (password.matches("\\d+")) { // Проверка, что не состоит только из цифр
            throw new IllegalArgumentException("Пароль не может состоять только из цифр.");
        }
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException("Пароль должен содержать буквы, цифры или знак подчеркивания");
        }
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.isEmpty()) {
            throw new NullPointerException("Логин не может быть пустым.");
        }
        if (login.length() >= 20) {
            throw new IllegalArgumentException("Логин должен быть меньше 20 символов.");
        }
        if (login.matches("\\d+")) { // Проверка, что логин не состоит только из цифр
            throw new IllegalArgumentException("Логин не может состоять только из цифр.");
        }
        if (!LOGIN_PATTERN.matcher(login).matches()) {
            throw new IllegalArgumentException("Логин должен содержать буквы, цифры или знак подчеркивания");
        }
        this.login = login;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    private void setConfirmPassword(String confirmPassword) {
        if (confirmPassword.isEmpty()) {
            throw new NullPointerException("Подтверждение пароля не может быть пустым.");
        }
        if (!this.password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Пароль и подтверждение пароля не совпадают.");
        }
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new NullPointerException();
        }
        if (!NAME_PATTERN.matcher(firstName).matches()) {
            throw new IllegalArgumentException("Имя должно содержать только буквы");
        }
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new NullPointerException();
        }
        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("Имя должно содержать только буквы");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new NullPointerException();
        }
        if (!NAME_PATTERN.matcher(lastName).matches()) {
            throw new IllegalArgumentException("Имя должно содержать только буквы");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new NumberFormatException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    public void update(User user) {
        this.date = LocalDateTime.now();
        this.password = user.getPassword();
        this.login = user.getLogin();
        this.confirmPassword = user.getConfirmPassword();
        this.firstName = user.getFirstName();
        this.name = user.getName();
        this.lastName = user.getLastName();//может не быть
        this.age = user.getAge();//может не быть
        this.isWorker = user.isWorker();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && isWorker == user.isWorker && Objects.equals(id, user.id) && Objects.equals(date, user.date) && Objects.equals(password, user.password) && Objects.equals(login, user.login) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(firstName, user.firstName) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, password, login, confirmPassword, firstName, name, lastName, age, isWorker);
    }

    @Override
    public String toString() {
        return id + "|" + date + "|" + login + "|" + password + "|" + confirmPassword + "|" + firstName + "|" +
                name + "|" + lastName + "|" + age + "|" + isWorker;
    }
}
