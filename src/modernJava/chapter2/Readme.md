## 동작 파라미터화 코드 전달하기

요구사항은 항상 변화가 있다. 기존의 있던 요구사항에서 추가적인 요구사항이 들어올 수 있고,
기존과 다른 요구사항으로 변경될 수 있다.
이러한 변화하는 요구사항은 소프트웨어 엔지니어링에서 피할 수 없다.

`동작 파라미터화` 를 이용하면 자주 변화하는 요구사항에
효과적으로 대응할 수 있다.

동작 파라미터란 아직은 어떻게 실행할 것인지 결정하지 않은 코드 블록을 의미한다.

- 동작 파라미터 사용방법
  - 동작을 캡슐화 한다. (Predicate를 구현한 클래스 생성)
  - 필터 함수의 메소드에 Predicate를 인자로 받게한 다음 구현한 클래스를 파라미터에 넣는다. 
## 익명 클래스

추상화된 조건들을 클래스로 정의하여 다양한 조건 클래스를 만들 수 있지만
한번 만 사용한다면 이러한 행위는 번거롭다고 생각할 수 있다.

한번 만 사용하거나 임시로 사용할 경우 익명클래스를 사용하면 편리하다.
익명클래스는 `이름 없는 클래스로 클래스 선언과 인스턴스화를 동시에 할 수 있다.`
익명 클래스는 추상 조건을 사용하는 곳에서 바로 만들어서 사용할 수 있다.

```
List<apple> redApples = filterapples(inventory, new ApplePredicate(){
    public boolean test(Apple apple){
        return RED.equals(apple.getcolor())
        }
  }
```

요구사항을 대응하는 방법

1. 단일 조건 필터링
2. 조건을 파라미터로 받기
    ```
    private List<Apple> filter(List<Apple> apples, String color){
        //TODO...
    }
    ```
3. 가능한 모든 속성을 필터링
   ```
   private List<Apple> filter(List<Apple> apples, String color, Integer weight, Boolean flag){
    // ...todo    
   }   
   ```

4. 추상적 조건으로 필터링
5. 익명 클래스 사용
6. 람다 표현식 사용
    ```
    fitlerApples(List<Apple> apples, (Apple apple) -> app.getColor().eqauls("RED"))
    ```
7. 리스트 형식으로 추상화
```
List<T> filter(List<T> list, Predicate<T> p){
   List<T> result = new ArrayList();
   for (T item : list) {
      if (p.test(t)) {
         result.add(t);   
      }
   }
   return result;
}
```
