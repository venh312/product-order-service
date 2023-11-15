package productorderservice.demo.product.port;

import productorderservice.demo.product.domain.Product;

public interface ProductPort {
    public void save(Product product);
    Product getProduct(Long productId);
}
