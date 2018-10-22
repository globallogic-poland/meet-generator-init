package meet.generator.init.ports.data;

import meet.generator.init.adapters.data.model.Countries;
import meet.generator.init.adapters.data.model.FirstNames;
import meet.generator.init.adapters.data.model.LastNames;

public interface DataProvider {

    FirstNames getFirstNames();

    LastNames getLastNames();

    Countries getCountries();
}
