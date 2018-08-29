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
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes= Application.class)
public class RestApiSchemaIT {
  @LocalServerPort
  int port;

  @Test
  public void validateThatImplementationMatchesDocumentationSpecification() {
    String apiContract = RestApiSchemaIT.class.getResource("/swagger-contract.yaml").getPath();
    String swaggerSchemaUrl = String.format("http://localhost:%d/v2/api-docs", port);
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    SwaggerAssertions.assertThat(swaggerSchemaUrl)
        .isEqualTo(apiContract);
  }
}