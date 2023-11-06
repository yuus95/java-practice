package modernJava.chapter13;

public interface InterfaceA {
    default void hello() {
        System.out.println("InterfaceA Hello");
    }
}
