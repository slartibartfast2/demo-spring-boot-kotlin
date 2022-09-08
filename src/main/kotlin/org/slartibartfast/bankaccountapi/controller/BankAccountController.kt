package org.slartibartfast.bankaccountapi.controller

import org.slartibartfast.bankaccountapi.model.dto.BankAccountDto
import org.slartibartfast.bankaccountapi.service.BankAccountService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bank-accounts")
class BankAccountController(private val bankAccountService: BankAccountService) {

    @GetMapping("/{accountNumber}")
    fun retrieveByAccountNumber(@PathVariable accountNumber: String): BankAccountDto? = bankAccountService.retrieveBankAccount(accountNumber)

    @GetMapping
    fun retrieveAll(): List<BankAccountDto> = bankAccountService.retrieveAllBankAccounts()

    @PostMapping
    fun createBankAccount(@RequestParam owner: String): BankAccountDto = bankAccountService.createBankAccount(owner)
}