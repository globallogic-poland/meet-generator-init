package meet.generator.init.adapters.generators;

import meet.generator.init.adapters.data.FileDataProvider;
import meet.generator.init.adapters.producers.providers.PatientProducerProvider;
import meet.generator.init.dto.Patient;
import meet.generator.init.ports.data.DataProvider;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Objects;

class PatientProducerTest {

    @Test
    void shouldGeneratePatient() {

        // given
        DataProvider dataProvider = new FileDataProvider();
        DetailsGenerator detailsGenerator = new DetailsGenerator(dataProvider);
        LocationGenerator locationGenerator = new LocationGenerator(dataProvider);
        PatientProducerProvider patientProducer = new PatientProducerProvider(detailsGenerator, locationGenerator);

        // when
        Flux<Patient> patientFlux = patientProducer.create(2);

        // then
        StepVerifier.create(patientFlux)
                .expectNextMatches(Objects::nonNull)
                .expectNextMatches(Objects::nonNull)
                .expectComplete()
                .verify();
    }

}