## Chapter1 

스트림이란?
- 한 번에 한 개씩 만들어지는 연속적인 데이터 항목들의 모임
- 스트림 API는 파이프라인을 만드는데 필요한 많은 메서드를 제공한다. 
- 스트림 API의 핵심은 우리가 하려는 작업을 고수준으로 추상화해서 일련의 스트림으로 만들어 처리할 수 있다. 
- 스트림 파이프 라인을 이용해서 입력 부분을 여러 CPU 코어에 쉽게 할당할 수 있다는 부가적인 이득도 얻을 수 있다. 
- 공짜 병렬성도 얻을 수 있다. 


동작 파라미터화로 메서드에 코드 전달하기
- 자바8에 추가된 두 번째 프로그램 개념은 코드 일부를 API로 전달하는 기능이다 (동작 파라미터화)
- 스트림 API는 연산의 동작을 파라미터화할 수 있느 코드를 전달한다는 사상에 기초한다.

병렬성과 공유 가변 데이터

- 보통 다른 코드와 동시에 실행하더라도 안전하게 실행할 수 있는 코드를 만들려면 공유된 가변 데이터를 접근하지 않아야 한다. 이러한 함수를 순수 함수, 부작용 없는 함수, 상태 없는 함수라고 부른다.
- 기존에 사용하는 Synchronized 를 이용해서 공유된 가변 데이터를 보호할 수 있지만 병렬성을 무력화 시킨다. (다중 코어가 순차적으로 실행되야 되기 떄문에)
- 함수형 프로그래밍의 패러다임의 핵심적인 사항은 공유되지 않은 가변 데이터, 메섣, 함수 코드를 다른 메서드로 전달하는 기능이다.