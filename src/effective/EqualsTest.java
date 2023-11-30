package effective;

import java.util.Objects;

public class EqualsTest {


    class Crew {
        String uuid;
        Integer idx;

        /**
         * this == 0 를 사용하는 이유는 성능 최적화를 위해서
         * getClass 를 사용하면 리스코프 치환 법칙에서 위배된다.
         *
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Crew)) return false;
            Crew crew = (Crew) o;
            return Objects.equals(uuid, crew.uuid) && Objects.equals(idx, crew.idx);
        }

        @Override
        public int hashCode() {
            return Objects.hash(uuid, idx);
        }
    }
}
