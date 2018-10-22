package meet.generator.init.adapters.generators;

import meet.generator.init.adapters.FileDataProvider;
import meet.generator.init.adapters.generators.gen.DetailsGenerator;
import meet.generator.init.adapters.generators.gen.LocationGenerator;
import meet.generator.init.dto.Doctor;
import meet.generator.init.ports.DataProvider;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Objects;

class DoctorProducerTest {

    @Test
    void shouldGenerateDoctor() {

        // given
        DataProvider dataProvider = new FileDataProvider();
        DetailsGenerator detailsGenerator = new DetailsGenerator(dataProvider);
        LocationGenerator locationGenerator = new LocationGenerator(dataProvider);
        DoctorProducer doctorProducer = new DoctorProducer(detailsGenerator, locationGenerator);

        // when
        Flux<Doctor> doctorFlux = doctorProducer.generate(2);

        // then
        StepVerifier.create(doctorFlux)
                .expectNextMatches(Objects::nonNull)
                .expectNextMatches(Objects::nonNull)
                .expectComplete()
                .verify();
    }


}