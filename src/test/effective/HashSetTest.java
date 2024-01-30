package test.effective;

import main.effective.HashSetImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HashSetTest {


    @Test
    public void HashSetTest() {
        List<String> simpleList = List.of("Hello", "Simple", "Test");
        HashSetImpl<String> objects = new HashSetImpl<>();
        objects.addAll(simpleList);
        int addCount = objects.getAddCount();
        Assertions.assertEquals(addCount,simpleList.size());
    }
}
