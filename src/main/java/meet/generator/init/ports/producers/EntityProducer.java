package meet.generator.init.ports.producers;

import reactor.core.publisher.Flux;

public interface EntityProducer<T> {

    Flux<T> generate(long count);
}
