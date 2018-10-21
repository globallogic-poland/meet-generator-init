package meet.generator.init.adapters;


import meet.generator.init.config.FirstNames;
import meet.generator.init.config.LastNames;
import meet.generator.init.ports.StaticDataProvider;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileStaticDataProviderTest {

    private StaticDataProvider staticDataProvider = new FileStaticDataProvider();

    @Test
    void shouldParseFirstNames() {

        FirstNames result = staticDataProvider.getFirstNames();

        assertThat(result.getFemales())
                .hasSize(330);
        assertThat(result.getMales())
                .hasSize(330);

        staticDataProvider.getLastNames();
    }

    @Test
    void shouldParseLastNames() {

        // TODO: finish impl
        LastNames result = staticDataProvider.getLastNames();

//        assertThat(result.getFemales())
//                .hasSize(330);
//        assertThat(result.getMales())
//                .hasSize(330);

    }

}