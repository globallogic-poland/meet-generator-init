package meet.generator.init.config.data;

import meet.generator.init.adapters.data.FileDataProvider;
import meet.generator.init.ports.data.DataProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataProviderConfig {

    @Bean
    public DataProvider dataProvider() {
        return new FileDataProvider();
    }
}
