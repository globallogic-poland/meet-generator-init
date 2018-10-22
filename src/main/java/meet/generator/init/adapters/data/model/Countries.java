package meet.generator.init.adapters.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

@Getter
@Setter
public class Countries {

    @Singular
    private List<Country> countries;

}
