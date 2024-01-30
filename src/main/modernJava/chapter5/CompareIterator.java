package main.modernJava.chapter5;

import java.util.Arrays;

public class CompareIterator {

    /**
     * 1만개의 (Integer Collection,int collection) 에서 짝수를 구하는 로직을
     * 내부반복과 외부반복의 속도 차이를 알아보자.
     *
     *
     * intArray 함수 내부반복 : 실행 시간: 295958 나노초 ,   외부반복: 함수 실행 시간: 10434208 나노초
     * IntegerArray 내부반복 585041나노초 , 외부 반복 :5818667나노초
     *
     * 함수형 인터페이스를 이용해서 활용해보기
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arrays = new int[100000];
        int[] newIntArray = new int[100000];
        Integer[] integerArray = new Integer[100000];
        Integer[] newIntegerArray = new Integer[100000];

        for (int i = 0; i < 100000; i++) {
            arrays[i] = i + 1;
            integerArray[i] = i + 1;
        }

        long startTime = System.nanoTime();
        // 함수 실행
        for (int i = 0; i < 100000; i++) {
            if (integerArray[i] % 2 == 0) {
                newIntegerArray[i] = 1;
            }
        }

        printResult(startTime);

        long streamTimeByIntArray = System.nanoTime();
        Arrays.stream(integerArray).forEach(i -> {
            if (i % 2 == 0) {
                newIntegerArray[i - 1] = 1;
            }
        });
        printResult(streamTimeByIntArray);

    }

    private static void printResult(long startTime) {
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("함수 실행 시간: " + duration + " 나노초");
        System.out.println("함수 실행 시간: " + duration / 1000000 + " 밀리초");
    }
}
