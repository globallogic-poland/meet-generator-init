package meet.generator.init.adapters.generators;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meet.generator.init.adapters.generators.gen.DetailsGenerator;
import meet.generator.init.adapters.generators.gen.LocationGenerator;
import meet.generator.init.adapters.generators.results.Details;
import meet.generator.init.adapters.generators.results.Location;
import meet.generator.init.dto.Patient;
import meet.generator.init.ports.DataProvider;
import meet.generator.init.ports.generators.EntityProducer;
import reactor.core.publisher.Flux;

@Slf4j
@AllArgsConstructor
public class PatientProducer implements EntityProducer<Patient> {

    private final DataProvider dataProvider;
    private final DetailsGenerator detailsGenerator;
    private final LocationGenerator locationGenerator;

    @Override
    public Flux<Patient> generate(long count) {

        Flux<Details> detailsFlux = Flux.fromIterable(() -> detailsGenerator);
        Flux<Location> locationFlux = Flux.fromIterable(() -> locationGenerator);
        // TODO: add age and diseases
        // TODO: merge 2 streams

//        Flux.zip(detailsFlux, locationFlux, (details, location) -> {
//            log.info("{}", details);
//            return Patient.builder().build();
//        })
//                .take(count);

        Details details = detailsGenerator.next();
        Location location = locationGenerator.next();

        Patient patient = Patient.builder()
                .firstName(details.getFirstName())
                .lastName(details.getLastName())
//                .age() // TODO: add
                .sex(details.getSex())
//                .chronicDiseases() // TODO: add
                .country(location.getCountry())
                .city(location.getCity())
                .district(location.getDistrict())
                .build();

        return Flux.just(patient);


    }
}
