package homework.homework12;

import homework.homework12.exception.PhoneNumberFormatException;
import homework.homework12.exception.DateFormatException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Person {
    private String firstName;
    private String Name;
    private String lastName;
    private LocalDate birthDay;
    private int phoneNumber;
    private char sex;
    private int age;

    public Person(String line) {
        String[] param = line.split(" ");
        String patern = "^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.(19|20)\\d{2}$";

        if (param.length != 7)
            throw new IllegalArgumentException("Неверное количество параметров");
        if (!param[3].matches(patern))
            throw new DateFormatException("Неверная дата");
        if (Integer.parseInt(param[4]) <= 0)
            throw new PhoneNumberFormatException("Неверный номер");
        if (!(param[5].equals("f") || param[5].equals("m")))
            throw new IllegalArgumentException("Неверно указан пол");
        if (Integer.parseInt(param[6]) < 0)
            throw new IllegalArgumentException("Возраст не может быть отрицательный");

        this.firstName = param[0];
        this.Name = param[1];
        this.lastName = param[2];
        this.birthDay = LocalDate.parse(param[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.phoneNumber = Integer.parseInt(param[4]);
        this.sex = (param[5]).charAt(0);
        this.age = Integer.parseInt(param[4]);

        writeInFile(param);
    }

    private void writeInFile(String[] param) {
        String path = "src/homework/homework12/person/" + param[0] + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            String line = "";
            String[] newParam = Arrays.copyOfRange(param, 0, param.length - 1);
            for (String str : newParam) {
                line += "<" + str + ">";
            }
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
