package main.effective;

import java.util.Collection;
import java.util.Set;

public class InstrumentedSet<E> extends main.effective.ForwardingSet<E> {
    private int count = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        count++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        count += c.size();
        return super.addAll(c);
    }

    @Override
    public int size() {
        return count;
    }
}
