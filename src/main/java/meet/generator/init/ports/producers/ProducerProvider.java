package meet.generator.init.ports.producers;

import reactor.core.publisher.Flux;

public interface ProducerProvider<T> {

    Flux<T> create(long count);
}
