package meet.generator.init.config;

import lombok.*;

import java.util.Map;

@Getter
@Setter
public class Countries {

    @Singular
    private Map<String, Country> countries;

}
