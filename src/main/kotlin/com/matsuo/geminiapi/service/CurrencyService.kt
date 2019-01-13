package com.matsuo.geminiapi.service

import com.matsuo.geminiapi.domain.Currency
import com.matsuo.geminiapi.domain.CurrencyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class CurrencyService {

    @Autowired
    lateinit var currencyRepository : CurrencyRepository

    fun findAll() : List<Currency> {
        return currencyRepository.findAll()
    }

    fun save(name : String , symbol : String) : Currency {
        return currencyRepository.save(Currency(name = name,symbol = symbol))
    }

    fun delete(id : Long) {
        currencyRepository.findById(id)?.let { currency -> currencyRepository.delete(currency.get()) }
    }

}