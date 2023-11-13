package productorderservice.demo.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import productorderservice.demo.order.OrderService;
import productorderservice.demo.order.OrderSteps;
import productorderservice.demo.product.ProductSteps;
import productorderservice.demo.product.service.ProductService;

@SpringBootTest
public class PaymentServiceTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;

    @Test
    void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        orderService.createOrder(OrderSteps.상품주문요청_생성());

        PaymentRequest request = PaymentSteps.주문결제요청_생성();
        paymentService.payment(request);
    }
}
