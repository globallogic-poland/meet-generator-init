package meet.generator.init.adapters.generators.gen;

import meet.generator.init.adapters.data.FileDataProvider;
import meet.generator.init.adapters.generators.DetailsGenerator;
import meet.generator.init.adapters.generators.model.Details;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DetailsGeneratorTest {

    @Test
    void shouldGenerateNotNullDetails() {

        // given
        DetailsGenerator detailsGenerator = new DetailsGenerator(new FileDataProvider());

        // when
        Details details = detailsGenerator.next();

        // then
        assertThat(details).isNotNull();
        assertThat(details.getFirstName()).isNotNull();
        assertThat(details.getLastName()).isNotNull();
        assertThat(details.getSex()).isNotNull();
    }

}