package homework.homework09.race;

import homework.homework09.car.Car;

public abstract class Race {

    private int distance;
    private String route;
    private int prizeFund;
    private Car[] member;

    public Race(int distance, String route, int prizeFund, Car[] member) {
        this.distance = distance;
        this.route = route;
        this.prizeFund = prizeFund;
        this.member = member;
    }
}
