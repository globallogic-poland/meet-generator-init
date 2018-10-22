package meet.generator.init.adapters.generators.results;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Builder
@Value
public class Location {

    String country;

    String city;

    String district;

}
