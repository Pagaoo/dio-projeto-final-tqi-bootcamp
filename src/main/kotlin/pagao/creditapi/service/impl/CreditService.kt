package pagao.creditapi.service.impl

import org.springframework.stereotype.Service
import pagao.creditapi.entity.Credit
import pagao.creditapi.exception.BussinesException
import pagao.creditapi.respository.CreditRepository
import pagao.creditapi.service.ICreditService
import java.time.LocalDate
import java.util.*

@Service
class CreditService(private val creditRepository: CreditRepository, private val customerService: CustomerService): ICreditService {
    override fun saveCredit(credit: Credit): Credit {
        this.validDayFirstInstallment(credit.dayFirstInstallment)
        credit.apply { customer = customerService.findById(credit.customer?.id!!) }
        return this.creditRepository.save(credit)
    }

    override fun findAllCreditByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)

    override fun findCreditByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BussinesException("Credit Code $creditCode não encontrado"))

        if (credit.customer?.id == customerId) {
           return credit
        } else {
            throw BussinesException("Cliente não encontrado conforme o Credit Code cedido! Procure o Administrador do sistema")
        }
    }

    private fun validDayFirstInstallment(fisrtDay: LocalDate): Boolean {
        return if (fisrtDay.isBefore(LocalDate.now().plusMonths(3))) true
        else throw BussinesException("Data inválida")
    }
}