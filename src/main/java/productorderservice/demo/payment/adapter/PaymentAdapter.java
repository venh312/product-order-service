package productorderservice.demo.payment.adapter;

import org.springframework.stereotype.Component;
import productorderservice.demo.order.domain.Order;
import productorderservice.demo.order.adapter.OrderRepository;
import productorderservice.demo.payment.domain.Payment;
import productorderservice.demo.payment.port.PaymentPort;

@Component
public class PaymentAdapter implements PaymentPort {
    private final productorderservice.demo.payment.adapter.PaymentGateway PaymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    PaymentAdapter(productorderservice.demo.payment.adapter.PaymentGateway paymentGateway, PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.PaymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
    }

    @Override
    public void pay(int totalPrice, String cardNumber) {
        PaymentGateway.excute(totalPrice, cardNumber);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
