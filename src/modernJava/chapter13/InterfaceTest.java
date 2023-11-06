package modernJava.chapter13;

public interface InterfaceTest {
    void setX(Integer x);

    Integer getX();

    default void moveX(Integer x) {
        setX(getX() + x);
    }
}
