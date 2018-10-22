package meet.generator.init.adapters.generators;

import meet.generator.init.adapters.FileDataProvider;
import meet.generator.init.adapters.generators.gen.LocationGenerator;
import meet.generator.init.dto.Clinic;
import meet.generator.init.ports.DataProvider;
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