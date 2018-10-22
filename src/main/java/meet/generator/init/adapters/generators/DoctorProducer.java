package meet.generator.init.adapters.generators;

import lombok.AllArgsConstructor;
import meet.generator.init.adapters.generators.results.Details;
import meet.generator.init.adapters.generators.results.Location;
import meet.generator.init.dto.Doctor;
import meet.generator.init.dto.Specialization;
import meet.generator.init.ports.generators.EntityProducer;
import meet.generator.init.ports.generators.Generator;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class DoctorProducer implements EntityProducer<Doctor> {

    private final Generator<Details> detailsGenerator;
    private final Generator<Location> locationGenerator;

    @Override
    public Flux<Doctor> generate(long count) {
        return Flux.zip(
                Flux.fromIterable(() -> detailsGenerator),
                Flux.fromIterable(() -> locationGenerator),
                this::createDoctor)
                .take(count);
    }

    private Doctor createDoctor(Details details, Location location) {
        return Doctor.builder()
                .firstName(details.getFirstName())
                .lastName(details.getLastName())
                .specialization(Specialization.GYNECOLOGIST) // TODO: change that
                .country(location.getCountry())
                .city(location.getCity())
                .district(location.getDistrict())
                .build();
    }

}
