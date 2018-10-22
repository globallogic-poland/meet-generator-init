package meet.generator.init.config.generators;

import meet.generator.init.adapters.generators.ClinicProducer;
import meet.generator.init.adapters.generators.DoctorProducer;
import meet.generator.init.adapters.generators.PatientProducer;
import meet.generator.init.adapters.generators.gen.DetailsGenerator;
import meet.generator.init.adapters.generators.gen.LocationGenerator;
import meet.generator.init.adapters.generators.results.Details;
import meet.generator.init.adapters.generators.results.Location;
import meet.generator.init.dto.Clinic;
import meet.generator.init.dto.Doctor;
import meet.generator.init.dto.Patient;
import meet.generator.init.ports.DataProvider;
import meet.generator.init.ports.generators.EntityProducer;
import meet.generator.init.ports.generators.Generator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorConfig {

    @Bean
    public EntityProducer<Doctor> doctorGenerator(Generator<Details> detailsGenerator,
                                                  Generator<Location> locationGenerator) {
        return new DoctorProducer(detailsGenerator, locationGenerator);
    }

    @Bean
    public EntityProducer<Clinic> clinicGenerator(Generator<Location> locationGenerator) {
        return new ClinicProducer(locationGenerator);
    }

    @Bean
    public EntityProducer<Patient> patientGenerator(Generator<Details> detailsGenerator,
                                                    Generator<Location> locationGenerator) {
        return new PatientProducer(detailsGenerator, locationGenerator);
    }

    @Bean
    public Generator<Details> detailsGenerator(DataProvider dataProvider) {
        return new DetailsGenerator(dataProvider);
    }

    @Bean
    public Generator<Location> locationGenerator(DataProvider dataProvider) {
        return new LocationGenerator(dataProvider);
    }

}
