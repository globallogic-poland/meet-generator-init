package meet.generator.init.adapters.generators.gen;

import lombok.RequiredArgsConstructor;
import meet.generator.init.adapters.data.model.Country;
import meet.generator.init.adapters.generators.results.Location;
import meet.generator.init.ports.DataProvider;
import meet.generator.init.ports.generators.Generator;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class LocationGenerator implements Generator<Location> {

    private final DataProvider dataProvider;

    private final Random randomCountry = new Random();
    private final Random randomCity = new Random();
    private final Random randomDistrict = new Random();

    @Override
    public Location next() {

        List<Country> countries = dataProvider.getCountries().getCountries();
        Country country = random(countries, randomCountry);

        List<String> cities = country.getCities();
        String city = random(cities, randomCity);

        int districtIdx = randomDistrict.nextInt(10);

        return Location.builder()
                .country(country.getName())
                .city(city)
                .district("District" + districtIdx)
                .build();
    }
}
