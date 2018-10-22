package meet.generator.init.adapters.generators;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meet.generator.init.adapters.generators.results.Details;
import meet.generator.init.adapters.generators.results.Location;
import meet.generator.init.dto.Disease;
import meet.generator.init.dto.Patient;
import meet.generator.init.ports.generators.EntityProducer;
import meet.generator.init.ports.generators.Generator;
import reactor.core.publisher.Flux;

@Slf4j
@AllArgsConstructor
public class PatientProducer implements EntityProducer<Patient> {

    private final Generator<Details> detailsGenerator;
    private final Generator<Location> locationGenerator;

    @Override
    public Flux<Patient> generate(long count) {
        return Flux.zip(
                Flux.fromIterable(() -> detailsGenerator),
                Flux.fromIterable(() -> locationGenerator),
                this::createPatient)
                .take(count);
    }

    private Patient createPatient(Details details, Location location) {
        return Patient.builder()
                .firstName(details.getFirstName())
                .lastName(details.getLastName())
                .age(30) // TODO: change that
                .sex(details.getSex())
                .chronicDisease(Disease.ADHD.toString()) // TODO: change that
                .country(location.getCountry())
                .city(location.getCity())
                .district(location.getDistrict())
                .build();
    }
}
