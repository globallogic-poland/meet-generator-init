package meet.generator.init.dto;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Patient {

    String id;

    String name;

    int age;

    Sex sex;

    Set<String> chronicDiseases;

    String district;

    String city;

    String country;

}
