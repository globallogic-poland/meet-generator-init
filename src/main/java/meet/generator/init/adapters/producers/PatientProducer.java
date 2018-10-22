package meet.generator.init.adapters.producers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meet.generator.init.adapters.RandomValue;
import meet.generator.init.adapters.generators.model.Details;
import meet.generator.init.adapters.generators.model.Location;
import meet.generator.init.dto.Disease;
import meet.generator.init.dto.Patient;
import meet.generator.init.ports.generators.Generator;
import meet.generator.init.ports.producers.EntityProducer;
import reactor.core.publisher.Flux;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class PatientProducer implements EntityProducer<Patient> {

    private final Generator<Details> detailsGenerator;
    private final Generator<Location> locationGenerator;
    private final RandomValue randomValue;
    private final Random randomDisease = new Random();
    private final Random randomAge = new Random();

    @Override
    public Flux<Patient> generate(long count) {
        return Flux.zip(
                Flux.fromIterable(() -> detailsGenerator),
                Flux.fromIterable(() -> locationGenerator),
                this::createPatient)
                .take(count);
    }

    private Patient createPatient(Details details, Location location) {
        int age = randomAge.nextInt(100);
        Disease disease = randomValue.fromArray(Disease.values(), randomDisease);
        return Patient.builder()
                .firstName(details.getFirstName())
                .lastName(details.getLastName())
                .age(age)
                .sex(details.getSex())
                .chronicDisease(disease)
                .country(location.getCountry())
                .city(location.getCity())
                .district(location.getDistrict())
                .build();
    }
}
