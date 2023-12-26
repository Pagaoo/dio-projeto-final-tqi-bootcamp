package pagao.creditapi.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import pagao.creditapi.entity.Address
import pagao.creditapi.entity.Customer
import java.math.BigDecimal

data class CustomerDTO(
    @field:NotEmpty(message = "FirstName Input invalido") val firstName: String,
    @field:NotEmpty(message = "Last Name Input Invalido")  val lastName: String,
    @field:NotEmpty(message = "Cpf Input Invalido") val cpf:String,
    @field:NotEmpty(message = "Income input Invalido") val income: BigDecimal,
    @field:NotEmpty(message = "email input Invalido")
    @field:Email(message = "email invalido") val email: String,
    @field:NotEmpty(message = "password input invalido") val password: String,
    @field:NotEmpty(message = "zipcode input invalido") val zipCode: String,
    @field:NotEmpty(message = "street input invalido") val street: String
    ) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}