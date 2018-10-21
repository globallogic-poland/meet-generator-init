package meet.generator.init.ports;

import meet.generator.init.config.data.model.Countries;
import meet.generator.init.config.data.model.FirstNames;
import meet.generator.init.config.data.model.LastNames;

public interface DataProvider {

    FirstNames getFirstNames();

    LastNames getLastNames();

    Countries getCountries();
}
