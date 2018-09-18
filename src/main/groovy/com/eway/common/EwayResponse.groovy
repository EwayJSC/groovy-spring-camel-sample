package com.eway.common

import groovy.transform.Canonical
import groovy.transform.builder.Builder

@Canonical
@Builder
class EwayResponse<T> {

    EwayResponse() {}

    EwayResponse(T data) {
        this.data = data
    }

    private T data

    T getData() {
        return data
    }

    void setData(T data) {
        this.data = data
    }
}
