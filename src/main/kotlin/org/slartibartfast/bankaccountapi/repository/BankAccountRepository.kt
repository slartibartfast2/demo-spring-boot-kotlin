package org.slartibartfast.bankaccountapi.repository

import org.slartibartfast.bankaccountapi.model.AccountType
import org.slartibartfast.bankaccountapi.model.BankAccount
import org.slartibartfast.bankaccountapi.model.dto.BankAccountDto
import org.slartibartfast.bankaccountapi.model.toDto
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import javax.annotation.PostConstruct

@Repository
class BankAccountRepository {
    val bankAccounts = mutableListOf<BankAccount>()

    @PostConstruct
    fun init() {
        save(BankAccount(1, "021000021", "John Smith", BigDecimal.valueOf(100), AccountType.DEFAULT))
        save(BankAccount(2, "011401533", "Paul Walker", BigDecimal.valueOf(1000), AccountType.GOLD))
        save(BankAccount(3, "091000019", "Kate Morgan", BigDecimal.valueOf(-100), AccountType.DEFAULT))
    }

    fun findByAccountNumber(accountNumber: String): BankAccount? = bankAccounts.singleOrNull { it.accountNum == accountNumber }

    fun findAll(): List<BankAccount> = bankAccounts

    fun save(bankAccount: BankAccount): BankAccountDto {
        bankAccount.id = (bankAccounts.maxByOrNull { it.id }?.id ?: 0) + 1
        bankAccounts.add(bankAccount)
        return bankAccount.toDto()
    }

    fun update(bankAccount: BankAccount): BankAccount {
        val index = bankAccounts.indexOfFirst { it.id == bankAccount.id }
        if (index >= 0) {
            bankAccounts[index] = bankAccount
        }
        return bankAccount
    }

    fun removeById(id: Int): Boolean = bankAccounts.removeIf { it.id == id }

}