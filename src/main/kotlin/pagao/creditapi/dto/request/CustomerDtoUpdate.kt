package pagao.creditapi.dto.request

import jakarta.validation.constraints.NotEmpty
import pagao.creditapi.entity.Address
import pagao.creditapi.entity.Customer
import java.math.BigDecimal

data class CustomerDtoUpdate(
    @field:NotEmpty(message = "FirstName Input invalido") val firstName: String,
    @field:NotEmpty(message = "Last Name Input Invalido")  val lastName: String,
    @field:NotEmpty(message = "Income input Invalido") val income: BigDecimal,
    @field:NotEmpty(message = "zipcode input invalido") val zipCode: String,
    @field:NotEmpty(message = "street input invalido") val street: String
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        income = this.income,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}