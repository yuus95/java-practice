package effective;

import main.effective.InstrumentedSet;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentedSetTest {

    @Test
    void name() {
        List<String> test = List.of("Test", "Test1", "Test2");
        HashSet<String> stringSet = new HashSet<>();
        InstrumentedSet instrumentedSet = new InstrumentedSet<>(stringSet);
        boolean b = instrumentedSet.addAll(test);
        int size = instrumentedSet.size();
        System.out.println(size);

    }
}
