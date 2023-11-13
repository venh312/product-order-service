package productorderservice.demo.payment;

public class PaymentSteps {
    public static PaymentRequest 주문결제요청_생성() {
        Long orderId = 1L;
        String cardNumber = "1100-2302-0032";
        return new PaymentRequest(orderId, cardNumber);
    }
}