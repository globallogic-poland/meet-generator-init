package meet.generator.init.adapters.generators;

import lombok.RequiredArgsConstructor;
import meet.generator.init.adapters.RandomValue;
import meet.generator.init.dto.Specialization;
import meet.generator.init.ports.generators.Generator;

import java.util.Random;

@RequiredArgsConstructor
public class SpecializationGenerator implements Generator<Specialization> {

    private final RandomValue randomValue;

    private final Random random = new Random();

    @Override
    public Specialization next() {
        return randomValue.fromArray(Specialization.values(), random);
    }
}
