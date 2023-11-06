## 13장 디폴트 메소드

### 디폴트메소드를 왜 사용할까?

혼자서 모든 것을 제어할 수 없을 때, 사용할 수 있다.
인터페이스를 이용하여 라이브러리를 제공할 경우, 기존 방식으로 신규 메소드를 추가하게 된다면 
예외를 던진다. 구현체들은 해당 메소드들을 제공해야되기 때문이다. 
이럴 때, 디폴트 메소드를 사용하게 된다면 추가적인 메소드를 구현하지 않고 사용할 수 있다.


```java
public interface InterfaceTest {
    void setX(Integer x);

    Integer getX();

    default void moveX(Integer x) {
        setX(getX() + x);
    }
}
```

기존에는 getX와 setX를 제공했을 때, 새로운 API버전 또는 라이브러리 버전에서는
X를 이동시키는 메소드를 부분적으로 구현체를 만들어서 제공 하고 싶다면 위에 코드처럼 작성하여 제공할 수 있다. 



### 디폴트메소드로 발생하는 다이아몬드 문제

특정 클래스가 다중상속을 받을 때 상속을 해주는 클래스가 동일한 메소드 시그니처를 제공할 경우
어떤 메소드를 상속받아서 사용해야 될 지 모를 때, 발생한다. 

해당 이슈는 C++ 에서 많이 발생한다. C++는 다중상속을 지원하기 때문이다. 
자바에서는 인터페이스를 통한 디폴트 메소드를 사용할 경우, 발생한다. 

이 때 다중 상속을 해결할 수 있는 방법은 아래와같아.

- 인터페이스 defaultMethod 보단 클래스 구현체를 사용한다. 
```java
public class ExtendA implements InterfaceA{
    @Override
    public void hello() {
        System.out.println("ExtendA Method Hello");
    }
}

interface InterfaceA {
    default void hello(){
        System.out.println("HelloA");
    };
}

public class DefaultMethodEx extends ExtendA implements InterfaceB{
    public static void main(String[] args) {
        new DefaultMethodEx().hello();
    }
}
```

- 서로다른 인터페이스에서 같은 메소드를 제공할 경우, 구현체에서 지정해줘야 한다.

```java
interface InterfaceA {
    default void hello() {
        System.out.println("HelloA");
    }
}

interface InterfaceB {
    default void hello() {
        System.out.println("HelloB");
    }
}

public class ExampleClass implements InterfaceA, InterfaceB {
    @Override
    public void hello() {
        InterfaceA.super.hello();
    }
}
```
x.super.hello() 처럼 정의해줘야 한다. 
이 때 x는 특정 인터페이스 네이밍을 정의해줘야한다. ex) InterfaceA

