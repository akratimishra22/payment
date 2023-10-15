package hotel.reservation.system.payment.controller;

import hotel.reservation.system.payment.model.Payment;
import hotel.reservation.system.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> makePayment(@Valid @RequestBody Payment payment) {
        try {
            return new ResponseEntity<>(paymentService.makePayment(payment), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        try {
            List<Payment> payments = paymentService.getAllPayments();

            if (payments.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(payments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @Valid @RequestBody Payment updatedPayment) {
        Payment payment = paymentService.updatePayment(id, updatedPayment);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        boolean deleted = paymentService.deletePayment(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("reservationId/{reservationId}")
    public ResponseEntity<Payment> getPaymentByReservationId(@PathVariable Long reservationId) {
        Payment payment = paymentService.getPaymentByReservationId(reservationId);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/{updatedStatus}")
    public ResponseEntity<Payment> updatePaymentStatus(@PathVariable Long id, @PathVariable String updatedStatus) {
        Payment payment = paymentService.updatePaymentStatus(id, updatedStatus);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/reservationId{reservationId}")
    public ResponseEntity<Payment> updateReservationId(@PathVariable Long id, @PathVariable Long reservationId) {
        Payment payment = paymentService.updateReservationId(id, reservationId);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
