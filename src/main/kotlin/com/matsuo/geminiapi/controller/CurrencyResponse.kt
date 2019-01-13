package com.matsuo.geminiapi.controller

import com.matsuo.geminiapi.domain.Currency

data class CurrencyResponse (
        val currencies : List<Currency>
) {

    class Builder {
        var currencyList: List<Currency>? = null

        fun build(): CurrencyResponse = CurrencyResponse(
                requireNotNull(currencyList)
        )

        companion object {
            fun build(f: Builder.() -> Unit): CurrencyResponse {
                val builder = Builder()
                builder.f()
                return builder.build()
            }
        }
    }
}