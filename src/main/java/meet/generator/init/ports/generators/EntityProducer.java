package meet.generator.init.ports.generators;

import reactor.core.publisher.Flux;

public interface EntityProducer<T> {

    Flux<T> generate(long count);
}
