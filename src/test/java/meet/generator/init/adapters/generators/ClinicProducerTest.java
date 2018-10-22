package meet.generator.init.adapters.generators;

import meet.generator.init.adapters.data.FileDataProvider;
import meet.generator.init.adapters.producers.ClinicProducer;
import meet.generator.init.dto.Clinic;
import meet.generator.init.ports.data.DataProvider;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Objects;

class ClinicProducerTest {

    @Test
    void shouldGenerateClinic() {

        // given
        DataProvider dataProvider = new FileDataProvider();
        LocationGenerator locationGenerator = new LocationGenerator(dataProvider);
        ClinicProducer clinicProducer = new ClinicProducer(locationGenerator);

        // when
        Flux<Clinic> clinicFlux = clinicProducer.generate(2);

        // then
        StepVerifier.create(clinicFlux)
                .expectNextMatches(Objects::nonNull)
                .expectNextMatches(Objects::nonNull)
                .expectComplete()
                .verify();
    }

}