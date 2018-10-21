package meet.generator.init.config;

import meet.generator.init.adapters.generators.ClinicProducer;
import meet.generator.init.adapters.generators.DoctorProducer;
import meet.generator.init.adapters.generators.PatientProducer;
import meet.generator.init.dto.Clinic;
import meet.generator.init.dto.Doctor;
import meet.generator.init.dto.Patient;
import meet.generator.init.ports.DataProvider;
import meet.generator.init.ports.generators.EntityProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorConfig {

    @Bean
    public EntityProducer<Doctor> doctorGenerator(DataProvider dataProvider) {
        return new DoctorProducer(dataProvider);
    }

    @Bean
    public EntityProducer<Clinic> clinicGenerator(DataProvider dataProvider) {
        return new ClinicProducer(dataProvider);
    }

    @Bean
    public EntityProducer<Patient> patientGenerator(DataProvider dataProvider) {
        return new PatientProducer(dataProvider);
    }

}
