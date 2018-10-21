package meet.generator.init.adapters.generators.gen;

import lombok.AllArgsConstructor;
import meet.generator.init.adapters.data.model.FirstNames;
import meet.generator.init.adapters.data.model.LastNames;
import meet.generator.init.adapters.generators.results.Details;
import meet.generator.init.dto.Sex;
import meet.generator.init.ports.DataProvider;
import meet.generator.init.ports.generators.Generator;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class DetailsGenerator implements Generator<Details> {

    private final DataProvider dataProvider;

    private final Random randomSex = new Random();
    private final Random randomFirstName = new Random();
    private final Random randomLastNameEntries = new Random();
    private final Random randomLastName = new Random();

    @Override
    public Details next() {

        Sex sex = random(Sex.values(), randomSex);

        FirstNames allNames = dataProvider.getFirstNames();
        List<String> firstNames = sex.equals(Sex.MALE) ? allNames.getMales() : allNames.getFemales();
        String firstName = random(firstNames, randomFirstName);

        List<LastNames.LastNamesEntry> lastNamesEntries = dataProvider.getLastNames().getLastNames();
        LastNames.LastNamesEntry lastNamesEntry = random(lastNamesEntries, randomLastNameEntries);

        List<String> lastNames = lastNamesEntry.getNames();
        String lastName = random(lastNames, randomLastName);

        return Details.builder()
                .firstName(firstName)
                .lastName(lastName)
                .sex(sex)
                .build();
    }
}
