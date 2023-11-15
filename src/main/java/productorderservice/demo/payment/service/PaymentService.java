package productorderservice.demo.payment.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productorderservice.demo.order.domain.Order;
import productorderservice.demo.payment.domain.Payment;
import productorderservice.demo.payment.port.PaymentPort;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "payments")
public class PaymentService {
    private final PaymentPort paymentPort;

    PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> payment(@RequestBody PaymentRequest request) {
        Order order = paymentPort.getOrder(request.orderId());
        Payment payment = new Payment(order, request.cardNumber());
        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
