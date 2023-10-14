package hotel.reservation.system.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	@Column(name = "paymentMethod")
	private String paymentMethod;

	@Column(name = "paymentStatus")
	private String paymentStatus;

	@Column(name = "paymentDate")
	private LocalDateTime paymentDate;

	@PrePersist
	public void prePersist() {
		paymentDate = LocalDateTime.now();
	}
}