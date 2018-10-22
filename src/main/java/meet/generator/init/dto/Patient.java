package meet.generator.init.dto;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Patient {

    String id;

    // TODO: compare with other DTOs: name -> first/last name
    String firstName;

    String lastName;

    int age;

    Sex sex;

    @Singular
    Set<String> chronicDiseases;

    String district;

    String city;

    String country;

}
