package meet.generator.init.adapters.data.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    private String code;

    private String name;

    @Singular
    private List<String> cities;
}
