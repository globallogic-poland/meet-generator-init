package meet.generator.init.ports;

import meet.generator.init.config.FirstNames;
import meet.generator.init.config.LastNames;

public interface StaticDataProvider {

    FirstNames getFirstNames();

    LastNames getLastNames();
    
}
