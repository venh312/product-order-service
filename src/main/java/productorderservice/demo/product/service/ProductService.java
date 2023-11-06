package productorderservice.demo.product.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productorderservice.demo.product.ProductPort;
import productorderservice.demo.product.domain.Product;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/products")
public class ProductService {
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

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable Long productId) {
        Product product = productPort.getProduct(productId);

        GetProductResponse response = new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getDiscountPolicy());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{productId}")
    @Transactional
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productId,
            @RequestBody UpdateProductRequest request) {
        Product product = productPort.getProduct(productId);

        product.update(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);

        return ResponseEntity.ok().build();
    }

}
