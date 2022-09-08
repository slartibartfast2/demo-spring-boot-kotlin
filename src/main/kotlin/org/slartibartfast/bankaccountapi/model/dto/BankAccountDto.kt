package org.slartibartfast.bankaccountapi.model.dto

import java.math.BigDecimal

data class BankAccountDto(
    var accountNum: String,
    var ownerName: String,
    var balance: BigDecimal
)