package collections;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        TempList<String> tempStringList = new TempList<>();
        tempStringList.add("test");
        System.out.println(tempStringList.get(0).toString());
    }

}

class TempList<T> {
    public List<T> temp = new ArrayList<>();

    public void add(T obj) {
        temp.add(obj);
    }

    public T get(int order) {
        return temp.get(order);
    }
}
