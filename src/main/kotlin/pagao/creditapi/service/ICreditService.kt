package pagao.creditapi.service

import pagao.creditapi.entity.Credit
import java.util.UUID

interface ICreditService {
    fun saveCredit(credit: Credit): Credit
    fun findAllCreditByCustomer(customerId: Long): List<Credit>
    fun findCreditByCreditCode(customerId: Long, creditCode: UUID): Credit

}