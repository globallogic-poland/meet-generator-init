package meet.generator.init.adapters.generators.gen;

import meet.generator.init.adapters.RandomValue;
import meet.generator.init.adapters.data.FileDataProvider;
import meet.generator.init.adapters.generators.LocationGenerator;
import meet.generator.init.adapters.generators.model.Location;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationGeneratorTest {

    @Test
    void shouldGenerateNotNullLocation() {

        // given
        LocationGenerator locationGenerator = new LocationGenerator(new FileDataProvider(), new RandomValue());

        // when
        Location location = locationGenerator.next();

        // then
        assertThat(location).isNotNull();
        assertThat(location.getCountry()).isNotNull();
        assertThat(location.getCity()).isNotNull();
        assertThat(location.getDistrict()).isNotNull();
    }

}