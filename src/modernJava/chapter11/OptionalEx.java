package modernJava.chapter11;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {

        //기존 방식대로 내부 객체를 참조한다면 Null체크를 계속해줘야한다.
        Insurance insurance = new Insurance("test");
        Car car = new Car(insurance);
        Person person = new Person(null);

        Insurance insuranceNull = person.getCar() != null ? person.getCar().getInsurance() : null;
        Optional<Person> personOpt = Optional.ofNullable(person);
        String unKnown = personOpt.map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unKnown");

        System.out.println(unKnown);

        Insurance testInsurance = new Insurance("test");
        Insurance notEqualsTest = new Insurance("notEquals");
        boolean testResult = contains(Optional.of(testInsurance));
        boolean notEqualsResult = contains(Optional.of(notEqualsTest));
        boolean nullResult = contains(Optional.empty());
        System.out.println("testResult  => " + testResult);
        System.out.println("notEqualsResult  => " + notEqualsResult);
        System.out.println("nullResult  => " + nullResult);
    }

    public static String getInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCarOpt)
                .flatMap(Car::getInsuranceOpt)
                .map(Insurance::getName)
                .orElse("UnKnow");
    }

    public String testLocalDate(LocalDateTime time) {
        return Optional.ofNullable(time)
                .map(time1 -> time1.format(DateTimeFormatter.ofPattern("YYYY-mm-dd")))
                .orElse(null);
    }

    public static boolean contains(Optional<Insurance> insuranceOpt) {
        return insuranceOpt.filter(item -> item.getName().equals("test"))
                .isPresent();
    }

    public static String getInsurance(Optional<Person> personOpt, Optional<Car> carOpt) {
        return personOpt.flatMap(person -> {
                    return carOpt.flatMap(Car::getInsuranceOpt);
                }).map(Insurance::getName)
                .orElse("unKnown");
    }
}
