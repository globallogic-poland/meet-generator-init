package meet.generator.init.config;

import meet.generator.init.adapters.FileDataProvider;
import meet.generator.init.ports.DataProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataProviderConfig {

    @Bean
    public DataProvider dataProvider() {
        return new FileDataProvider();
    }
}
