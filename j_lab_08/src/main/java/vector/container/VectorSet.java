package vector.container;

import java.util.Set;

/**
 * Created by AdminY on 02.12.2015.
 */
public class VectorSet extends VectorCollection implements Set {
    public VectorSet() {
        super();
    }

    @Override
    public boolean add(Object o) {
        return !this.contains(o) && super.add(o);
    }
}
