package meet.generator.init.config.senders;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.PositiveOrZero;

@Component
@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "producer")
public class ProducerSettings {

    @PositiveOrZero
    private int doctorCount;

    @PositiveOrZero
    private int patientCount;

    @PositiveOrZero
    private int clinicCount;

}
