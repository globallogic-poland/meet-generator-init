package meet.generator.init.adapters.generators;

import meet.generator.init.adapters.RandomValue;
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
        RandomValue randomValue = new RandomValue();
        DataProvider dataProvider = new FileDataProvider();
        DetailsGenerator detailsGenerator = new DetailsGenerator(dataProvider, randomValue);
        LocationGenerator locationGenerator = new LocationGenerator(dataProvider, randomValue);
        DiseaseGenerator diseaseGenerator = new DiseaseGenerator(randomValue);
        PatientProducerProvider patientProducer = new PatientProducerProvider(
                detailsGenerator, locationGenerator, diseaseGenerator);

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