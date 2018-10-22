package meet.generator.init.ports.generators;

import java.util.Iterator;

public interface Generator<T> extends Iterator<T> {

    T next();

    default boolean hasNext() {
        return true;
    }

}
