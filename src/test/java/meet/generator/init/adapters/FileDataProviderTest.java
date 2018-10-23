package meet.generator.init.adapters;


import meet.generator.init.adapters.data.FileDataProvider;
import meet.generator.init.adapters.data.model.Country;
import meet.generator.init.adapters.data.model.FirstNames;
import meet.generator.init.adapters.data.model.LastNames;
import meet.generator.init.ports.data.DataProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

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
        List<LastNames.LastNamesEntry> result = dataProvider.getLastNames().getLastNames();
        Optional<LastNames.LastNamesEntry> optionalPolishNames = result.stream()
                .filter(entry -> entry.getCountry().equals("pl"))
                .findAny();
        assertThat(optionalPolishNames)
                .isNotEmpty();

        assertThat(optionalPolishNames.get().getNames())
                .hasSize(4306);
    }

    @Test
    @DisplayName("Should parse Polish cities")
    void shouldParseCountries() {
        List<Country> result = dataProvider.getCountries().getCountries();
        Optional<Country> polandOptional = result.stream()
                .filter(c -> c.getCode().equals("pl"))
                .findAny();

        assertThat(polandOptional)
                .isNotEmpty();

        assertThat(polandOptional.get().getCities())
                .containsAnyOf("WARSAW", "Katowice");
    }


}