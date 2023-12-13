package pagao.creditapi.service.impl

import org.springframework.stereotype.Service
import pagao.creditapi.entity.Customer
import pagao.creditapi.exception.BussinesException
import pagao.creditapi.respository.CustomerRespository
import pagao.creditapi.service.ICustomerService

@Service
class CustomerService(private val customerRespository: CustomerRespository): ICustomerService  {
    override fun saveCustomer(customer: Customer): Customer = this.customerRespository.save(customer)

    override fun findById(id: Long): Customer = this.customerRespository.findById(id).orElseThrow{
        throw BussinesException("id: $id não encontrado")
    }

}