package productorderservice.demo.order;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import productorderservice.demo.ApiTest;
import productorderservice.demo.product.ProductSteps;
import productorderservice.demo.product.service.ProductService;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderApiTest extends ApiTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        CreateOrderRequest request = 상품주문요청_생성();
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/orders")
                .then()
                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private CreateOrderRequest 상품주문요청_생성() {
        Long productId = 1L;
        int  quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }

}
