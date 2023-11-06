package modernJava.chapter13;

public class DefaultMethodEx implements InterfaceA, InterfaceB {
    public static void main(String[] args) {
        new DefaultMethodEx().hello();
    }

    @Override
    public void hello() {
        InterfaceA.super.hello();
    }
}

