package productorderservice.demo.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import productorderservice.demo.product.ProductSteps;
import productorderservice.demo.product.service.ProductService;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Test
    void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        CreateOrderRequest request = 상품주문요청_생성();

        orderService.createOrder(request);
    }

    private CreateOrderRequest 상품주문요청_생성() {
        Long productId = 1L;
        int  quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }

}
