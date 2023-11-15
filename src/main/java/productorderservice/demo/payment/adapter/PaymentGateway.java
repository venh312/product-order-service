package productorderservice.demo.payment.adapter;

public interface PaymentGateway {
    void excute(int totalPrice, String cardNumber);
}
