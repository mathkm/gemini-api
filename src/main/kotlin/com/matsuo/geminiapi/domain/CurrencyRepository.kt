package com.matsuo.geminiapi.domain

import org.springframework.data.jpa.repository.JpaRepository

interface CurrencyRepository : JpaRepository<Currency,Long> {
}