package meet.generator.init.adapters.generators;

import meet.generator.init.adapters.data.FileDataProvider;
import meet.generator.init.adapters.producers.providers.DoctorProducerProvider;
import meet.generator.init.dto.Doctor;
import meet.generator.init.ports.data.DataProvider;
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
        DoctorProducerProvider doctorProducer = new DoctorProducerProvider(detailsGenerator, locationGenerator);

        // when
        Flux<Doctor> doctorFlux = doctorProducer.create(2);

        // then
        StepVerifier.create(doctorFlux)
                .expectNextMatches(Objects::nonNull)
                .expectNextMatches(Objects::nonNull)
                .expectComplete()
                .verify();
    }


}