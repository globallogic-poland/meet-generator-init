package meet.generator.init.adapters.producers.providers;

import lombok.RequiredArgsConstructor;
import meet.generator.init.adapters.generators.model.Location;
import meet.generator.init.dto.Clinic;
import meet.generator.init.ports.generators.Generator;
import meet.generator.init.ports.producers.ProducerProvider;
import reactor.core.publisher.Flux;

import java.util.Random;

@RequiredArgsConstructor
public class ClinicProducerProvider implements ProducerProvider<Clinic> {

    private static final String CLINIC = "Clinic";

    private final Generator<Location> locationGenerator;

    private final Random random = new Random();

    @Override
    public Flux<Clinic> create(long count) {
        return Flux.fromIterable(() -> locationGenerator)
                .map(this::createClinic)
                .take(count);
    }

    private Clinic createClinic(Location location) {
        return Clinic.builder()
                .country(location.getCountry())
                .city(location.getCity())
                .district(location.getDistrict())
                .name(CLINIC + random.nextInt(30))
                .build();
    }

}
