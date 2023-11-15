package productorderservice.demo.order.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productorderservice.demo.order.domain.Order;
import productorderservice.demo.order.port.OrderPort;
import productorderservice.demo.product.domain.Product;

@RestController
@RequestMapping("/orders")
public class OrderService {
    private final OrderPort orderPort;

    OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.productId());
        Order order = new Order(product, request.quantity());
        orderPort.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
