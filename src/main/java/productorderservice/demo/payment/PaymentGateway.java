package productorderservice.demo.payment;

public interface PaymentGateway {
    void excute(int totalPrice, String cardNumber);
}
