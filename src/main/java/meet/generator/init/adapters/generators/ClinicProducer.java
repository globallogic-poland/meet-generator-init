package meet.generator.init.adapters.generators;

import lombok.AllArgsConstructor;
import meet.generator.init.dto.Clinic;
import meet.generator.init.ports.DataProvider;
import meet.generator.init.ports.generators.EntityProducer;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class ClinicProducer implements EntityProducer<Clinic> {

    private final DataProvider dataProvider;

    @Override
    public Flux<Clinic> generate(long count) {
        return null;
    }
}
