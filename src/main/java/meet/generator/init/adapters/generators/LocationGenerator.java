package meet.generator.init.adapters.generators;

import lombok.RequiredArgsConstructor;
import meet.generator.init.adapters.RandomValue;
import meet.generator.init.adapters.generators.model.Location;
import meet.generator.init.adapters.data.model.Country;
import meet.generator.init.ports.data.DataProvider;
import meet.generator.init.ports.generators.Generator;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class LocationGenerator implements Generator<Location> {

    private static final String DISTRICT = "District";
    
    private final DataProvider dataProvider;
    private final RandomValue randomValue;
    private final Random randomCountry = new Random();
    private final Random randomCity = new Random();
    private final Random randomDistrict = new Random();

    @Override
    public Location next() {

        List<Country> countries = dataProvider.getCountries().getCountries();
        Country country = randomValue.fromList(countries, randomCountry);

        List<String> cities = country.getCities();
        String city = randomValue.fromList(cities, randomCity);

        int districtIdx = randomDistrict.nextInt(10);

        return Location.builder()
                .country(country.getName())
                .city(city)
                .district(DISTRICT + districtIdx)
                .build();
    }
}
