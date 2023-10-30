package modernJava.chapter11;

import javax.swing.text.html.Option;
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
    }
}
