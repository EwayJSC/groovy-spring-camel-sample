package com.eway.event_hub.config

import groovy.transform.Canonical
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 8/30/18.*/
@Component
@ConfigurationProperties(prefix = "clickhouse")
@Canonical
class ClickHouseConfig {
    @Value('$clickhouse.host')
    String host
    @Value('$clickhouse.port')
    String port
    @Value('$clickhouse.adflex_db')
    String adflexDb
    @Value('$clickhouse.masoffer_db')
    String masofferDb
}
