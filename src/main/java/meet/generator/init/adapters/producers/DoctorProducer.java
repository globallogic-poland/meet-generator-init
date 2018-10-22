package meet.generator.init.adapters.producers;

import lombok.AllArgsConstructor;
import meet.generator.init.config.GeneratorBindings;
import meet.generator.init.config.senders.ProducerSettings;
import meet.generator.init.dto.Doctor;
import meet.generator.init.ports.producers.ProducerProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import reactor.core.publisher.Flux;

import static meet.generator.init.config.GeneratorBindings.DOCTOR_CREATE;

@AllArgsConstructor
@EnableBinding(GeneratorBindings.class)
public class DoctorProducer {

    private final ProducerProvider<Doctor> producerProvider;

    private final ProducerSettings settings;

    @StreamEmitter
    @Output(DOCTOR_CREATE)
    public Flux<Doctor> send() {
        return producerProvider.create(settings.getDoctorCount());
    }

}
