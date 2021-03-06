package meet.generator.init.adapters.generators.model;

import lombok.Builder;
import lombok.Value;
import meet.generator.init.dto.Sex;

@Builder
@Value
public class Details {

    String firstName;

    String lastName;

    Sex sex;
}
