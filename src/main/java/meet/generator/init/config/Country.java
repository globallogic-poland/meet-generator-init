package meet.generator.init.config;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    private String name;

    @Singular
    private List<String> cities;
}
