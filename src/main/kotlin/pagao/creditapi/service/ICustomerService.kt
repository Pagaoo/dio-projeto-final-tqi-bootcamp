package pagao.creditapi.service

import pagao.creditapi.entity.Customer

interface ICustomerService {
    fun saveCustomer(customer: Customer): Customer
    fun findById(id: Long): Customer

    fun deleteCustomer(id: Long)
}