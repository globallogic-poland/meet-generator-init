package meet.generator.init.adapters;


import meet.generator.init.config.data.model.Country;
import meet.generator.init.config.data.model.FirstNames;
import meet.generator.init.ports.DataProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FileDataProviderTest {

    private DataProvider dataProvider = new FileDataProvider();

    @Test
    void shouldParseFirstNames() {

        FirstNames result = dataProvider.getFirstNames();

        assertThat(result.getFemales())
                .hasSize(330)
                .containsAnyOf("Maria", "Katarzyna", "Danuta");
        assertThat(result.getMales())
                .hasSize(330)
                .containsAnyOf("Marek", "Jan", "Janusz");

        dataProvider.getLastNames();
    }

    @Test
    @DisplayName("Should parse Polish names")
    void shouldParseLastNames() {
        Map<String, List<String>> result = dataProvider.getLastNames().getLastNames();
        assertThat(result.get("pl"))
                .hasSize(4306);
    }

    @Test
    @DisplayName("Should parse Polish cities")
    void shouldParseCountries() {
        Map<String, Country> result = dataProvider.getCountries().getCountries();
        Country poland = result.get("pl");
        assertThat(poland.getCities())
                .containsAnyOf("WARSAW", "Katowice");
    }


}