package pagao.creditapi.respository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pagao.creditapi.entity.Customer

@Repository
interface CustomerRespository: JpaRepository<Customer, Long>  {
}