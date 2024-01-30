package main.modernJava.chapter11;

import java.util.Optional;

public class Person {
    private Car car;

    public Person(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Optional<Car> getCarOpt() {
        return Optional.ofNullable(this.car);
    }

}
