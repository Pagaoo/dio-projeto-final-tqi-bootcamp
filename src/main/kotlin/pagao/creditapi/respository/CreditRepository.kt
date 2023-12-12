package pagao.creditapi.respository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pagao.creditapi.entity.Credit

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
}