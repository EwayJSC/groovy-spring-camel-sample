package com.eway.event_hub.controller


import com.eway.event_hub.business.invoker.CollectorBusinessInvoker
import groovy.util.logging.Slf4j
import io.x10.commons.spring.controller.AbstractController
import io.x10.commons.spring.utils.SystemResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/collector")
@Slf4j
class CollectorController extends AbstractController<CollectorBusinessInvoker> {
    @Autowired
    private CollectorBusinessInvoker collectorBusiness

    @PostMapping()
    SystemResponse receive(@RequestBody Map<String, Object> payload) {
        log.info("CollectorController receive payload :" + payload)

        collectorBusiness.receive(payload)

        return perform(payload, invoker.&receive)
    }
}