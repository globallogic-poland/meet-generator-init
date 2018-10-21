package meet.generator.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GeneratorInitApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorInitApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

    }
}
