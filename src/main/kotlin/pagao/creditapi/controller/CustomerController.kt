package pagao.creditapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pagao.creditapi.service.impl.CustomerService

@RestController
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {

}