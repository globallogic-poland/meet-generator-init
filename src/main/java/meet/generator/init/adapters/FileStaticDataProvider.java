package meet.generator.init.adapters;

import lombok.Getter;
import meet.generator.init.config.CountriesCities;
import meet.generator.init.config.FirstNames;
import meet.generator.init.config.LastNames;
import meet.generator.init.ports.StaticDataProvider;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

@Service
@Getter
public class FileStaticDataProvider implements StaticDataProvider {

    private final FirstNames firstNames;
    private LastNames lastNames;
    private CountriesCities countriesCities;

    public FileStaticDataProvider() {
        firstNames = loadYaml("data/firstnames.yaml", FirstNames.class);
//        lastNames = loadYaml("data/lastnames.yaml", LastNames.class);
    }

    private <T> T loadYaml(String resourcePath, Class<T> klass) {
        Yaml yaml = new Yaml(new Constructor(klass));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(resourcePath);
        return yaml.load(inputStream);
    }

}
