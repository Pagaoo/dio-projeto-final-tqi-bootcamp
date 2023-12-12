package pagao.creditapi.service.impl

import org.springframework.stereotype.Service
import pagao.creditapi.entity.Credit
import pagao.creditapi.exception.BussinesException
import pagao.creditapi.respository.CreditRepository
import pagao.creditapi.service.ICreditService
import java.time.LocalDate

@Service
class CreditService(private val creditRepository: CreditRepository, private val customerService: CustomerService): ICreditService {
    override fun saveCredit(credit: Credit): Credit {
        this.validDayFirstInstallment(credit.dayFirstInstallment)
        credit.apply { customer = customerService.findById(credit.customer?.id!!) }
        return this.creditRepository.save(credit)
    }


    private fun validDayFirstInstallment(fisrtDay: LocalDate): Boolean {
        return if (fisrtDay.isBefore(LocalDate.now().plusMonths(3))) true
        else throw BussinesException("Data inválida")
    }
}