package homework.homework07;

public class Adult extends Person {
    public Adult(String name, long money, int age) {
        super(name, money, age);
        super.setTakeCredit(true);
        super.setTakeRestrictions(true);
        System.out.println("На кассе Взрослые");
    }

    @Override
    public String toString() {
        long debts = (super.getMoney() < 0) ? 0 - super.getMoney() : 0;
        return super.toString() + ". Долг магазину: " + debts;
    }
}
