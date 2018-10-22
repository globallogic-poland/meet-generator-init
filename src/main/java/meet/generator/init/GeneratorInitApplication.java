package meet.generator.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GeneratorInitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorInitApplication.class, args);
    }
}
