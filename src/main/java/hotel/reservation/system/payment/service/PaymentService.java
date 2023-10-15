package hotel.reservation.system.payment.service;

import hotel.reservation.system.payment.model.Payment;
import hotel.reservation.system.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.orElse(null);
    }

    public Payment getPaymentByReservationId(Long reservationId) {
        Optional<Payment> payment = paymentRepository.findByReservationId(reservationId);
        return payment.orElse(null);
    }

    public Payment makePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, String updatedStatus) {
        Optional<Payment> existingPayment = paymentRepository.findById(id);
        if (existingPayment.isPresent()) {
            Payment payment = existingPayment.get();
            payment.setPaymentStatus(updatedStatus);
            return paymentRepository.save(payment);
        } else {
            return null;
        }
    }
}


