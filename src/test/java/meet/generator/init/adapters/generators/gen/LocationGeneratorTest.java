package meet.generator.init.adapters.generators.gen;

import meet.generator.init.adapters.FileDataProvider;
import meet.generator.init.adapters.generators.results.Location;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationGeneratorTest {

    @Test
    void shouldGenerateNotNullLocation() {

        // given
        LocationGenerator locationGenerator = new LocationGenerator(new FileDataProvider());

        // when
        Location location = locationGenerator.next();

        // then
        assertThat(location).isNotNull();
        assertThat(location.getCountry()).isNotNull();
        assertThat(location.getCity()).isNotNull();
        assertThat(location.getDistrict()).isNotNull();
    }

}