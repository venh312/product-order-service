package productorderservice.demo.payment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import productorderservice.demo.ApiTest;
import productorderservice.demo.order.OrderSteps;
import productorderservice.demo.product.ProductSteps;

public class PaymentApiTest extends ApiTest {
    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        var request = PaymentSteps.주문결제요청_생성();
        var response = PaymentSteps.주문결제요청(request);

        Assertions.assertEquals(response.statusCode(), HttpStatus.OK.value());
    }
 }
