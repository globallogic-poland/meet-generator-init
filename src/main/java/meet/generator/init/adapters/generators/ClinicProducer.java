package meet.generator.init.adapters.generators;

import lombok.AllArgsConstructor;
import meet.generator.init.adapters.generators.results.Location;
import meet.generator.init.dto.Clinic;
import meet.generator.init.ports.generators.EntityProducer;
import meet.generator.init.ports.generators.Generator;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class ClinicProducer implements EntityProducer<Clinic> {

    private final Generator<Location> locationGenerator;

    @Override
    public Flux<Clinic> generate(long count) {
        return Flux.fromIterable(() -> locationGenerator)
                .map(location -> Clinic.builder()
                        .country(location.getCountry())
                        .city(location.getCity())
                        .district(location.getDistrict())
                        .name("Clinic23") // TODO: change that
                        .build())
                .take(count);
    }
}
