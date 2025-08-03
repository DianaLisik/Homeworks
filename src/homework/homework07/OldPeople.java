package homework.homework07;

public class OldPeople extends Person {
    public OldPeople(String name, long money, int age) {
        super(name, money, age);
        super.setTakeRestrictions(true);
        System.out.println("На кассе Пенсионер");
    }
}
