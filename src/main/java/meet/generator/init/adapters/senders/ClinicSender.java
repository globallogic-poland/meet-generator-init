package meet.generator.init.adapters.senders;

import lombok.AllArgsConstructor;
import meet.generator.init.config.GeneratorBindings;
import meet.generator.init.config.senders.ProducerSettings;
import meet.generator.init.dto.Clinic;
import meet.generator.init.ports.producers.EntityProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import reactor.core.publisher.Flux;

import static meet.generator.init.config.GeneratorBindings.CLINIC_CREATE;

@AllArgsConstructor
@EnableBinding(GeneratorBindings.class)
public class ClinicSender {

    private final EntityProducer<Clinic> producer;

    private final ProducerSettings settings;

    @StreamEmitter
    @Output(CLINIC_CREATE)
    public Flux<Clinic> send() {
        return producer.generate(settings.getClinicCount());
    }
}
