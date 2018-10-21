package meet.generator.init.adapters.generators.gen;

import meet.generator.init.ports.generators.Generator;

import java.util.Random;

// TODO: consider removing
public class AgeGenerator implements Generator<Integer> {

    private final Random random = new Random();

    @Override
    public Integer next() {
        return random.nextInt(100);
    }
}
