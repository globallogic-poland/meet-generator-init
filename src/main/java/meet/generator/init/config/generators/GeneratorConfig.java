package meet.generator.init.config.generators;

import meet.generator.init.adapters.RandomValue;
import meet.generator.init.adapters.generators.DetailsGenerator;
import meet.generator.init.adapters.generators.DiseaseGenerator;
import meet.generator.init.adapters.generators.LocationGenerator;
import meet.generator.init.adapters.generators.SpecializationGenerator;
import meet.generator.init.adapters.generators.model.Details;
import meet.generator.init.adapters.generators.model.Location;
import meet.generator.init.adapters.producers.providers.ClinicProducerProvider;
import meet.generator.init.adapters.producers.providers.DoctorProducerProvider;
import meet.generator.init.adapters.producers.providers.PatientProducerProvider;
import meet.generator.init.dto.*;
import meet.generator.init.ports.data.DataProvider;
import meet.generator.init.ports.generators.Generator;
import meet.generator.init.ports.producers.ProducerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorConfig {

    @Bean
    public ProducerProvider<Doctor> doctorGenerator(Generator<Details> detailsGenerator,
                                                    Generator<Location> locationGenerator,
                                                    Generator<Specialization> specializationGenerator) {
        return new DoctorProducerProvider(detailsGenerator, locationGenerator, specializationGenerator);
    }

    @Bean
    public ProducerProvider<Clinic> clinicGenerator(Generator<Location> locationGenerator) {
        return new ClinicProducerProvider(locationGenerator);
    }

    @Bean
    public ProducerProvider<Patient> patientGenerator(Generator<Details> detailsGenerator,
                                                      Generator<Location> locationGenerator,
                                                      Generator<Disease> diseaseGenerator) {
        return new PatientProducerProvider(detailsGenerator, locationGenerator, diseaseGenerator);
    }

    @Bean
    public Generator<Details> detailsGenerator(DataProvider dataProvider,
                                               RandomValue randomValue) {
        return new DetailsGenerator(dataProvider, randomValue);
    }

    @Bean
    public Generator<Location> locationGenerator(DataProvider dataProvider,
                                                 RandomValue randomValue) {
        return new LocationGenerator(dataProvider, randomValue);
    }

    @Bean
    public Generator<Disease> diseaseGenerator(RandomValue randomValue) {
        return new DiseaseGenerator(randomValue);
    }

    @Bean
    public Generator<Specialization> specializationGenerator(RandomValue randomValue) {
        return new SpecializationGenerator(randomValue);
    }

    @Bean
    public RandomValue randomValue() {
        return new RandomValue();
    }

}
