package org.slartibartfast.bankaccountapi.model

import org.slartibartfast.bankaccountapi.model.dto.BankAccountDto
import java.math.BigDecimal

data class BankAccount(
    var id: Int?,
    var accountNum: String,
    var ownerName: String,
    var balance: BigDecimal,
    var accountType: AccountType
)

fun BankAccount.toDto() = BankAccountDto(
    accountNum = accountNum,
    ownerName = ownerName,
    balance = balance
)