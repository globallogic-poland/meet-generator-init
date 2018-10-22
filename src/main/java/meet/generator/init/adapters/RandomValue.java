package meet.generator.init.adapters;

import java.util.List;
import java.util.Random;

public class RandomValue {

    public <T> T fromArray(T[] values, Random random) {
        int idx = random.nextInt(values.length);
        return values[idx];
    }

    public <T> T fromList(List<T> values, Random random) {
        int idx = random.nextInt(values.size());
        return values.get(idx);
    }
}
