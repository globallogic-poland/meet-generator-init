package meet.generator.init.adapters.generators;

import lombok.AllArgsConstructor;
import meet.generator.init.dto.Patient;
import meet.generator.init.ports.DataProvider;
import meet.generator.init.ports.generators.EntityProducer;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class PatientProducer implements EntityProducer<Patient> {

    private final DataProvider dataProvider;

    @Override
    public Flux<Patient> generate(long count) {
        return null;
    }
}
