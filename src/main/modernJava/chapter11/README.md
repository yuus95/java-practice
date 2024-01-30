## 11장


### Optional을 사용하는 이유를 생각하기
Optional을 사용하면 선택적으로 데이터값이 있다고 생각할 수 있기 때문에, 필수적으로 데이터가 있어야 하는경우
Optional을 사용하는것이 옳은 선택인지 생각해봐야한다. 선택적으로 값이 존재할 수 있는 경우에는
해당 객체를 반환하여 null체크를 복잡하지 않게 쉽게 이해할 수 있는 코드로 표현 할 수 있다. 



### map vs FlatMap
Optional객체에 포함되어 있는 Optional객체를
Optional 스트림을 사용해서 가져올 경우, FlatMap을 사용해야 한다.

flatMap의 반환값은 반드시 Optional객체로 반환해야한다.
```java
Optional<Person> testPerson=Optional.ofNullable(..);
// Map
        Optional<Optional<Car>>mapResult=testPerson.map(Car::getCarOpt);
// FlatMap 상단에 있는 Optional 평탄화 작업
        Optional<Car> mapResult=testPerson.flatMap(Car::getCarOpt);
```

### 도메인내에 Optional
객체 그래프에서 특정 객체가 Null일수 있기 때문에, 직렬화때는 사용안하더라도
특정 객체에 대한 NPE를 막기 위해 Optional로 값을 반환할 수 있는 메서드를 추가한다. 


### 기본형Optional을 사용하지 않기

기존 Stream 에서 기본형 스트림을 사용할 경우, 특화된 메소드를 사용할 수 있지만,
오히려 Optional에서는 특화된 메소드를 사용할 수도 없고, 기존 메소드도 타 Optional과 연계해서 사용할 수 없다. 

### 필터링 
