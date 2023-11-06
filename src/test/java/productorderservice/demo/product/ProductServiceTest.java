package productorderservice.demo.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import productorderservice.demo.product.service.GetProductResponse;
import productorderservice.demo.product.service.ProductService;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void 상품조회() {
        // 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());
        long productId = 1L;

        ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        Assertions.assertThat(response).isNotNull();
    }
}
