package com.eway.event_hub.controller

import com.eway.event_hub.business.invoker.CollectorBusinessInvoker
import com.eway.event_hub.config.ClickHouseConfig
import groovy.util.logging.Slf4j
import io.x10.commons.spring.controller.AbstractController
import io.x10.commons.spring.utils.SystemResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.sql.Connection
import java.sql.DriverManager

@RestController
@RequestMapping("/collector")
@Slf4j
class CollectorController extends AbstractController<CollectorBusinessInvoker> {
    private static String DB_URL
    private static Connection conn;

    @Autowired
    private ClickHouseConfig clickHouseConfig

    @Autowired
    private CollectorBusinessInvoker collectorBusiness

    @PostMapping()
    SystemResponse receive(@RequestBody Map<String, Object> payload) {
        if (!DB_URL) {
            DB_URL = "jdbc:clickhouse://".concat(clickHouseConfig.host).concat(":").concat(clickHouseConfig.port).concat("/").concat(clickHouseConfig.adflexDb)
            log.info("DB_URL :" + DB_URL)
        }
        if (!conn) conn = DriverManager.getConnection(DB_URL);

        log.info("CollectorController receive payload :" + payload)

        collectorBusiness.receive(payload)

        return perform(payload, invoker.&receive)
    }
}