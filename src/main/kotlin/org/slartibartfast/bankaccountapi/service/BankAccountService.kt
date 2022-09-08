package org.slartibartfast.bankaccountapi.service

import org.slartibartfast.bankaccountapi.model.AccountType
import org.slartibartfast.bankaccountapi.model.BankAccount
import org.slartibartfast.bankaccountapi.model.dto.BankAccountDto
import org.slartibartfast.bankaccountapi.model.toDto
import org.slartibartfast.bankaccountapi.repository.BankAccountRepository
import org.slartibartfast.bankaccountapi.service.logging.LoggerDelegate
import org.springframework.stereotype.Service
import java.math.BigDecimal
import kotlin.random.Random

@Service
class BankAccountService(
    private val bankAccountRepository: BankAccountRepository,
    private val bankAccountNumberService: BankAccountNumberService
) {

    companion object {
        private val loggerComp by LoggerDelegate()
    }

    fun createBankAccount(owner: String): BankAccountDto {
        loggerComp.info("bank account will be created for {}", owner)
        val id = Random.nextInt()
        val accountNumber = bankAccountNumberService.generateBankAccountNumber(id)
        val bankAccount = prepareBankAccount(id, accountNumber, owner)
        return bankAccountRepository.save(bankAccount).toDto()
    }

    private fun prepareBankAccount(id: Int, accountNumber: String, owner: String): BankAccount {
        return BankAccount(id, accountNumber, owner, BigDecimal.ZERO, AccountType.DEFAULT)
    }

    fun retrieveAllBankAccounts(): List<BankAccountDto> {
        return bankAccountRepository.findAll().map { bankAccount -> bankAccount.toDto() }
    }

    fun retrieveBankAccount(accountNumber: String): BankAccountDto? {
        return bankAccountRepository.findByAccountNumber(accountNumber)?.toDto()
    }

}