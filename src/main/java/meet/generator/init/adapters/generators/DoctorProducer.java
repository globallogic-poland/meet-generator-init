package meet.generator.init.adapters.generators;

import lombok.AllArgsConstructor;
import meet.generator.init.dto.Doctor;
import meet.generator.init.ports.DataProvider;
import meet.generator.init.ports.generators.EntityProducer;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class DoctorProducer implements EntityProducer<Doctor> {

    private final DataProvider dataProvider;

    @Override
    public Flux<Doctor> generate(long count) {
        return Flux.just();
    }
}
