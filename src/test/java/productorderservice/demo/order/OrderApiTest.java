package productorderservice.demo.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        var request = OrderSteps.상품주문요청_생성();
        var response = OrderSteps.상품주문요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
