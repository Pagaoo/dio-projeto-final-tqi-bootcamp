package pagao.creditapi.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pagao.creditapi.dto.request.CreditDTO
import pagao.creditapi.dto.response.CreditView
import pagao.creditapi.dto.response.CreditViewList
import pagao.creditapi.entity.Credit
import pagao.creditapi.service.impl.CreditService
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/credit")
class CreditController(private val creditService: CreditService) {

    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDTO: CreditDTO): ResponseEntity<CreditView> {
        val newCredit: Credit = this.creditService.saveCredit(creditDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(CreditView(newCredit))
    }

    @GetMapping
    fun getCreditListByCustomer(@RequestParam(value = "customer_id") customer_id: Long):
            ResponseEntity<List<CreditViewList>> {
        val creditList: List<CreditViewList> = this.creditService.findAllCreditByCustomer(customer_id).stream()
            .map { credit: Credit -> CreditViewList(credit)}
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditList)
    }

    @GetMapping("/{creditCode}")
    fun getByCreditCode(@PathVariable creditCode: UUID, @RequestParam(value = "customer_id") customer_id: Long):
            ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findCreditByCreditCode(customer_id, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}