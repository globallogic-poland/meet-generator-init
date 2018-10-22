package meet.generator.init.adapters.producers.providers;

import lombok.RequiredArgsConstructor;
import meet.generator.init.adapters.generators.model.Details;
import meet.generator.init.adapters.generators.model.Location;
import meet.generator.init.dto.Doctor;
import meet.generator.init.dto.Specialization;
import meet.generator.init.ports.generators.Generator;
import meet.generator.init.ports.producers.ProducerProvider;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple3;

@RequiredArgsConstructor
public class DoctorProducerProvider implements ProducerProvider<Doctor> {

    private final Generator<Details> detailsGenerator;
    private final Generator<Location> locationGenerator;
    private final Generator<Specialization> specializationGenerator;

    @Override
    public Flux<Doctor> create(long count) {
        return Flux.zip(
                Flux.fromIterable(() -> detailsGenerator),
                Flux.fromIterable(() -> locationGenerator),
                Flux.fromIterable(() -> specializationGenerator))
                .map(this::createDoctor)
                .take(count);
    }

    private Doctor createDoctor(Tuple3<Details, Location, Specialization> tuple) {
        return createDoctor(tuple.getT1(), tuple.getT2(), tuple.getT3());
    }

    private Doctor createDoctor(Details details, Location location, Specialization specialization) {
        return Doctor.builder()
                .firstName(details.getFirstName())
                .lastName(details.getLastName())
                .specialization(specialization)
                .country(location.getCountry())
                .city(location.getCity())
                .district(location.getDistrict())
                .build();
    }

}
