package org.slartibartfast.bankaccountapi.service

import org.slartibartfast.bankaccountapi.service.logging.LoggerDelegate
import org.springframework.stereotype.Service

@Service
class BankAccountNumberService {

    companion object {
        private val loggerComp by LoggerDelegate()
    }

    fun generateBankAccountNumber(id: Int) : String {
        val bankAccountNumber = "123"
        loggerComp.info("new bank account number generated, {}", bankAccountNumber)
        return bankAccountNumber
    }
}