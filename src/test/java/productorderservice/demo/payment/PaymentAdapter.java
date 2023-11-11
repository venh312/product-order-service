package productorderservice.demo.payment;

import productorderservice.demo.order.Order;
import productorderservice.demo.product.domain.DiscountPolicy;
import productorderservice.demo.product.domain.Product;

class PaymentAdapter implements PaymentPort {
    private final productorderservice.demo.payment.PaymentGateway PaymentGateway;
    private final PaymentRepository paymentRepository;

    PaymentAdapter(productorderservice.demo.payment.PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
        this.PaymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return new Order(new Product("상품1", 1000, DiscountPolicy.NONE), 2);
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
