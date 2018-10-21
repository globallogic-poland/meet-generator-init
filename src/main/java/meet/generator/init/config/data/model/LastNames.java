package meet.generator.init.config.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class LastNames {

    @Singular
    private Map<String, List<String>> lastNames;
}
