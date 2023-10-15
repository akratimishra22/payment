package hotel.reservation.system.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customerId", nullable = false)
	private Long customerId;

	@Column(name = "reservationId")
	private Long reservationId;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	@Column(name = "paymentStatus")
	private String paymentStatus;
}