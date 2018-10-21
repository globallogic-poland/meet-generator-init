package meet.generator.init.ports.generators;

import java.util.List;
import java.util.Random;

public interface Generator<T> {

    T next();

    default <U> U random(U[] values, Random random) {
        int idx = random.nextInt(values.length);
        return values[idx];
    }

    default <U> U random(List<U> values, Random random) {
        int idx = random.nextInt(values.size());
        return values.get(idx);
    }

}
