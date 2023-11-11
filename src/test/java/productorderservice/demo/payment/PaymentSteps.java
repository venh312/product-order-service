package productorderservice.demo.payment;

public class PaymentSteps {
    PaymentRequest 주문결제요청_생성() {
        Long orderId = 1L;
        String cardNumber = "1100-2302-0032";
        PaymentRequest request = new PaymentRequest(orderId, cardNumber);
        return request;
    }
}