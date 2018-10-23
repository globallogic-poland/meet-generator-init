package meet.generator.init.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GeneratorBindings {

    String PATIENT_CREATE = "patient-create";

    String DOCTOR_CREATE = "doctor-create";

    String CLINIC_CREATE = "clinic-create";

    @Output(PATIENT_CREATE)
    MessageChannel patientCreate();

    @Output(DOCTOR_CREATE)
    MessageChannel doctorCreate();

    @Output(CLINIC_CREATE)
    MessageChannel clinicCreate();
}
