package meet.generator.init.adapters.generators.gen;

import lombok.RequiredArgsConstructor;
import meet.generator.init.dto.Sex;
import meet.generator.init.ports.generators.Generator;

import java.util.Random;

@RequiredArgsConstructor
public class SexGenerator implements Generator<Sex> {

    private final Random random = new Random();

    @Override
    public Sex next() {
        return random(Sex.values(), random);
    }
}
