package productorderservice.demo.order.adapter;

import org.springframework.stereotype.Component;
import productorderservice.demo.order.domain.Order;
import productorderservice.demo.order.port.OrderPort;
import productorderservice.demo.product.adapter.ProductRepository;
import productorderservice.demo.product.domain.Product;

@Component
public class OrderAdapter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
