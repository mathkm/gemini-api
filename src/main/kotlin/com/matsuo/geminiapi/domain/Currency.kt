package com.matsuo.geminiapi.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Currency(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id",nullable = false)
        val id : Long? = null,
        @Column(name = "name",nullable = false)
        val name : String,
        @Column(name = "symbol",nullable = false)
        val symbol : String,
        @Column(name = "amount", nullable = true)
        val amount : BigDecimal = BigDecimal.ZERO
)