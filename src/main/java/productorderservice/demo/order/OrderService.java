package productorderservice.demo.order;

import org.springframework.stereotype.Component;
import productorderservice.demo.product.domain.Product;

@Component
class OrderService {
    private final OrderPort orderPort;

    OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.productId());
        Order order = new Order(product, request.quantity());
        orderPort.save(order);
    }
}
