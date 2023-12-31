package pagao.creditapi.entity

import jakarta.persistence.*
import pagao.creditapi.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
data class Credit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, unique = true)
    var creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    val dayFirstInstallment: LocalDate,
    @Column(nullable = false)
    val numberOfInstallment: Int,
    @Column(nullable = false)
    val status: Status = Status.IN_PROGRESS,
    @ManyToOne
    var customer: Customer? = null
)
