package meet.generator.init.adapters.senders;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meet.generator.init.config.GeneratorBindings;
import meet.generator.init.dto.Patient;
import meet.generator.init.ports.producers.EntityProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import reactor.core.publisher.Flux;

import static meet.generator.init.config.GeneratorBindings.PATIENT_CREATE;

@Slf4j
@AllArgsConstructor
@EnableBinding(GeneratorBindings.class)
public class PatientSender {

    private final EntityProducer<Patient> producer;

    @Output(PATIENT_CREATE)
    public Flux<Patient> send() {
        log.info("=== Sending patient");
        return producer.generate(1000);
    }

}
