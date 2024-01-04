package pagao.creditapi.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pagao.creditapi.dto.request.CustomerDTO
import pagao.creditapi.dto.request.CustomerDtoUpdate
import pagao.creditapi.dto.response.CustomerView
import pagao.creditapi.entity.Customer
import pagao.creditapi.service.impl.CustomerService

@RestController
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDTO: CustomerDTO): ResponseEntity<CustomerView> {
        val newCustomer: Customer = this.customerService.saveCustomer(customerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerView(newCustomer))
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomerById(@PathVariable id: Long) {
        this.customerService.deleteCustomer(id)
    }

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody @Valid customerDtoUpdate: CustomerDtoUpdate): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerDtoUpdate.toEntity(customer)
        val customerUpdated: Customer = this.customerService.saveCustomer(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }

}