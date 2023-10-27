package productorderservice.demo.product;

import static org.assertj.core.api.Assertions.*; // AssertJ 정적 임포트
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import productorderservice.demo.ApiTest;

@SpringBootTest
public class ProductApiTest extends ProductSteps {
    @Test
    void 상품등록() {
        final var request = 상품등록요청_생성();
        // API 요청
        final var response = 상품등록요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
