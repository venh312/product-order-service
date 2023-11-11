package productorderservice.demo.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

    private final PaymentSteps paymentSteps = new PaymentSteps();
    private PaymentService paymentService;
    private PaymentPort paymentPort;

    @BeforeEach
    void setUp() {
        PaymentGateway paymentGateway = new ConsolePaymentGateway();
        PaymentRepository paymentRepository = new PaymentRepository();
        paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    @Test
    void 상품주문() {
        PaymentRequest request = paymentSteps.주문결제요청_생성();
        paymentService.payment(request);
    }
}
