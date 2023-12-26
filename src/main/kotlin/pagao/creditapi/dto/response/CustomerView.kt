package pagao.creditapi.dto.response

import pagao.creditapi.entity.Customer
import java.math.BigDecimal

data class CustomerView(
    val id: Long?,
    val fistName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String
) {

    constructor(customer: Customer): this(
        id = customer.id,
        fistName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        password = customer.password,
        zipCode = customer.address.zipCode,
        street = customer.address.street
    )
}