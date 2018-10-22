package meet.generator.init.adapters.senders;

import lombok.AllArgsConstructor;
import meet.generator.init.config.GeneratorBindings;
import meet.generator.init.dto.Doctor;
import meet.generator.init.ports.producers.EntityProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import reactor.core.publisher.Flux;

import static meet.generator.init.config.GeneratorBindings.DOCTOR_CREATE;

@AllArgsConstructor
@EnableBinding(GeneratorBindings.class)
public class DoctorSender {

    private final EntityProducer<Doctor> producer;

    @Output(DOCTOR_CREATE)
    public Flux<Doctor> send() {
        return producer.generate(1000);
    }

}
