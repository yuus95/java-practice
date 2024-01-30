package main.effective;

import java.util.Collection;
import java.util.HashSet;

public class HashSetImpl<E> extends HashSet<E> {
    private int addCount = 0;

    public HashSetImpl() {
    }

    public HashSetImpl(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    /**
     * addAll을 하면 부모에서는 add를 호출한다.
     * 이 때 자식은 자신의 add를 사용하게 되므로 addCount는 하나의 요청당 2번이 증가한다.
     *   - addAll +1
     *   - add +1
     * @param c collection containing elements to be added to this collection
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
