package main.modernJava.chapter13;

public interface InterfaceB{
    default void hello() {
        System.out.println("InterfaceB Hello");
    }
}
