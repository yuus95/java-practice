package main.modernJava.chapter11;

import java.util.Optional;

public class Car {
    private Insurance insurance;

    public Car(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public Optional<Insurance> getInsuranceOpt() {
        return Optional.ofNullable(insurance);
    }
}
