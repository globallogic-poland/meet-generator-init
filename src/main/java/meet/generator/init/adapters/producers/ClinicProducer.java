package meet.generator.init.adapters.producers;

import lombok.AllArgsConstructor;
import meet.generator.init.config.GeneratorBindings;
import meet.generator.init.config.senders.ProducerSettings;
import meet.generator.init.dto.Clinic;
import meet.generator.init.ports.producers.ProducerProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import reactor.core.publisher.Flux;

import static meet.generator.init.config.GeneratorBindings.CLINIC_CREATE;

@AllArgsConstructor
@EnableBinding(GeneratorBindings.class)
public class ClinicProducer {

    private final ProducerProvider<Clinic> producerProvider;

    private final ProducerSettings settings;

    @StreamEmitter
    @Output(CLINIC_CREATE)
    public Flux<Clinic> send() {
        return producerProvider.create(settings.getClinicCount());
    }
}
