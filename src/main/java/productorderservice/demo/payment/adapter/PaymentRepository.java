package productorderservice.demo.payment.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import productorderservice.demo.payment.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
