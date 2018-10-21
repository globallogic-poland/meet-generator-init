package meet.generator.init.adapters.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

@Getter
@Setter
public class LastNames {

    @Singular
    private List<LastNamesEntry> lastNames;

    @Getter
    @Setter
    public static class LastNamesEntry {

        private String country;

        @Singular
        private List<String> names;
    }
}
