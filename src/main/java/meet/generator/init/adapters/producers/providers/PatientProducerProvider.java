package meet.generator.init.adapters.producers.providers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meet.generator.init.adapters.generators.model.Details;
import meet.generator.init.adapters.generators.model.Location;
import meet.generator.init.dto.Disease;
import meet.generator.init.dto.Patient;
import meet.generator.init.ports.generators.Generator;
import meet.generator.init.ports.producers.ProducerProvider;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple3;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class PatientProducerProvider implements ProducerProvider<Patient> {

    private final Generator<Details> detailsGenerator;
    private final Generator<Location> locationGenerator;
    private final Generator<Disease> diseaseGenerator;

    private final Random random = new Random();

    @Override
    public Flux<Patient> create(long count) {
        return Flux.zip(
                Flux.fromIterable(() -> detailsGenerator),
                Flux.fromIterable(() -> locationGenerator),
                Flux.fromIterable(() -> diseaseGenerator))
                .map(this::createPatient)
                .take(count);
    }

    private Patient createPatient(Tuple3<Details, Location, Disease> tuple) {
        return createPatient(tuple.getT1(), tuple.getT2(), tuple.getT3());
    }

    private Patient createPatient(Details details, Location location, Disease disease) {
        return Patient.builder()
                .firstName(details.getFirstName())
                .lastName(details.getLastName())
                .age(random.nextInt(100))
                .sex(details.getSex())
                .chronicDisease(disease)
                .country(location.getCountry())
                .city(location.getCity())
                .district(location.getDistrict())
                .build();
    }
}
