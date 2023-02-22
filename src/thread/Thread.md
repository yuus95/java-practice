## 스레드 개념정리

### Callable
```
 * A task that returns a result and may throw an exception. Implementors define a single method with no arguments called call.
 * The Callable interface is similar to Runnable, in that both are designed for classes
 * whose instances are potentially executed by another thread. A Runnable, however, does not return a result
 * and cannot throw a checked exception.
 
하나의 결과또는 에러를 반환한다.
구현체들은 파라미터가 없는 Call 이라고 불리는 메서드들을 정의한다.
Runnable 과 비슷한 생김새를 가지고 있다.
Runnable과 Callable 둘다 잠재적으로 다른 스레드에 의해 실행 될수 있는  
클래스들을 위해 생겨났다.
```


## ExecutorService

스레드를 우리가 직접 생성하고 종료하는 로직은
매번 중복된 로직을 처리해야하는 불편함을 지니고 있다.
`ExecutorService` 는 이러한 불편함을 해소해준다.
`shutDown()` 이라는 메소드을 사용하여 스레드를 종료시킬 수 있고.
스레드 관리할 수 있는 수많은 메소드들을 포함하고 있다. 
