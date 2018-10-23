package meet.generator.init.adapters.generators;

import lombok.RequiredArgsConstructor;
import meet.generator.init.adapters.RandomValue;
import meet.generator.init.adapters.data.model.FirstNames;
import meet.generator.init.adapters.data.model.LastNames;
import meet.generator.init.adapters.generators.model.Details;
import meet.generator.init.dto.Sex;
import meet.generator.init.ports.data.DataProvider;
import meet.generator.init.ports.generators.Generator;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class DetailsGenerator implements Generator<Details> {

    private final DataProvider dataProvider;
    private final RandomValue randomValue;
    private final Random randomSex = new Random();
    private final Random randomFirstName = new Random();
    private final Random randomLastNameEntries = new Random();
    private final Random randomLastName = new Random();

    @Override
    public Details next() {

        Sex sex = randomValue.fromArray(Sex.values(), randomSex);

        FirstNames allNames = dataProvider.getFirstNames();
        List<String> firstNames = sex.equals(Sex.MALE) ? allNames.getMales() : allNames.getFemales();
        String firstName = randomValue.fromList(firstNames, randomFirstName);

        List<LastNames.LastNamesEntry> lastNamesEntries = dataProvider.getLastNames().getLastNames();
        LastNames.LastNamesEntry lastNamesEntry = randomValue.fromList(lastNamesEntries, randomLastNameEntries);

        List<String> lastNames = lastNamesEntry.getNames();
        String lastName = randomValue.fromList(lastNames, randomLastName);

        return Details.builder()
                .firstName(firstName)
                .lastName(lastName)
                .sex(sex)
                .build();
    }
}
