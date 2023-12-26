package pagao.creditapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pagao.creditapi.service.impl.CreditService

@RestController
@RequestMapping("/credit")
class CreditController(private val creditService: CreditService) {
}