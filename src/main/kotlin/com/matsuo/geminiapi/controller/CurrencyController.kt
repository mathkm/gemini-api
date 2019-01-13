package com.matsuo.geminiapi.controller

import com.matsuo.geminiapi.service.CurrencyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CurrencyController {

    @Autowired
    lateinit var currencyService : CurrencyService

    @GetMapping
    fun findAll() : ResponseEntity<CurrencyResponse> {
        val currencies : CurrencyResponse = CurrencyResponse.Builder.build {
            currencyList = currencyService.findAll()
        }
        return ResponseEntity<CurrencyResponse>(currencies,HttpStatus.OK)
    }

    @PostMapping("/")
    fun save(@RequestBody request : CurrencyAddRequest) : ResponseEntity<HttpStatus>{
        currencyService.save(request.name,request.symbol)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Long) : ResponseEntity<HttpStatus> {
        currencyService.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}