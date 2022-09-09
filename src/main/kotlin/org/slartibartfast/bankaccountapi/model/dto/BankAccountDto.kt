package org.slartibartfast.bankaccountapi.model.dto

import java.math.BigDecimal

data class BankAccountDto(
    val accountNum: String,
    val ownerName: String,
    val balance: BigDecimal
)