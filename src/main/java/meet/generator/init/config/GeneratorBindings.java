package meet.generator.init.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GeneratorBindings {

    String PATIENT_CREATE = "patient-create-requests";

    String DOCTOR_CREATE = "doctor-create-requests";

    String CLINIC_CREATE = "clinic-create-requests";

    @Output(PATIENT_CREATE)
    MessageChannel patientCreateRequests();

    @Output(DOCTOR_CREATE)
    MessageChannel doctorCreateRequests();

    @Output(CLINIC_CREATE)
    MessageChannel clinicCreateRequests();
}
