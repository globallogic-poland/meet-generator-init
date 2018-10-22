package meet.generator.init.adapters.generators;

import lombok.RequiredArgsConstructor;
import meet.generator.init.adapters.RandomValue;
import meet.generator.init.dto.Disease;
import meet.generator.init.ports.generators.Generator;

import java.util.Random;

@RequiredArgsConstructor
public class DiseaseGenerator implements Generator<Disease> {

    private final RandomValue randomValue;

    private final Random random = new Random();

    @Override
    public Disease next() {
        return randomValue.fromArray(Disease.values(), random);
    }
}
