package it;

import com.hascode.tutorial.Application;
import io.github.robwin.swagger.test.SwaggerAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
public class RestApiSchemaIntegrationTest {

  @LocalServerPort
  int port;

  @Test
  public void validateThatImplementationMatchesDocumentationSpecification() {
    String apiContract = RestApiSchemaIntegrationTest.class.getResource("/swagger-contract.yaml").getPath();
    System.out.println(apiContract);
    String swaggerSchemaUrl = String.format("http://localhost:%d/v2/api-docs", port);
    SwaggerAssertions.assertThat(swaggerSchemaUrl)
        .isEqualTo(apiContract);
  }
}