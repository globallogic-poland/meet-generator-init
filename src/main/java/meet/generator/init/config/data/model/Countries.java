package meet.generator.init.config.data.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
public class Countries {

    @Singular
    private Map<String, Country> countries;

}
