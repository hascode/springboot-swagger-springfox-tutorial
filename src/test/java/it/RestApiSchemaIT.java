package it;

import com.hascode.tutorial.Application;
import io.github.robwin.swagger.test.SwaggerAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RestApiSchemaIT {
  @Test
  public void validateThatImplementationMatchesDocumentationSpecification() {
    String apiContract = RestApiSchemaIT.class.getResource("/swagger-contract.yaml").getPath();
    SwaggerAssertions.assertThat("http://localhost:8080/v2/api-docs")
        .isEqualTo(apiContract);
  }
}