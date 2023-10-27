package productorderservice.demo.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/products")
class ProductService {
    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody AddProductRequest request) {
        Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public GetProductResponse getProduct(Long productId) {
        Product product = productPort.getProduct(productId);

        return new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getDiscountPolicy());
    }

}
