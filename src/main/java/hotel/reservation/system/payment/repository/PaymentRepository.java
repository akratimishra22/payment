package hotel.reservation.system.payment.repository;


import hotel.reservation.system.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
