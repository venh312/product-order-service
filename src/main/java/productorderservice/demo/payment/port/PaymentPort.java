package productorderservice.demo.payment.port;

import productorderservice.demo.order.domain.Order;
import productorderservice.demo.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
