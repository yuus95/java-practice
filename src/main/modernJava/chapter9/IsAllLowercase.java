package main.modernJava.chapter9;

public class IsAllLowercase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
