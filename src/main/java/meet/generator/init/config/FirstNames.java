package meet.generator.init.config;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

@Getter
@Setter
public class FirstNames {

    @Singular
    private List<String> females;

    @Singular
    private List<String> males;
}
