package productorderservice.demo.order.port;

import productorderservice.demo.order.domain.Order;
import productorderservice.demo.product.domain.Product;

public interface OrderPort {
    public Product getProductById(Long productId);

    public void save(Order order);
}
