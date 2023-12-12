package pagao.creditapi.service

import pagao.creditapi.entity.Credit

interface ICreditService {
    fun saveCredit(credit: Credit): Credit
}