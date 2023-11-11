package productorderservice.demo.payment;

import productorderservice.demo.order.Order;

interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
