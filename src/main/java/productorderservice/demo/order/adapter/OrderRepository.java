package productorderservice.demo.order.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import productorderservice.demo.order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
