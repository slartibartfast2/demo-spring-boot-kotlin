package org.slartibartfast.bankaccountapi.service

import org.slartibartfast.bankaccountapi.service.logging.LoggerDelegate
import org.springframework.stereotype.Service

@Service
class BankAccountNumberService {

    companion object {
        private val loggerComp by LoggerDelegate()

        private val allowedCharsMap = sortedMapOf(
            "A" to 10,
            "B" to 11,
            "C" to 12,
            "D" to 13,
            "E" to 14,
            "F" to 15,
            "G" to 16,
            "H" to 17,
            "I" to 18,
            "J" to 19,
            "K" to 20,
            "L" to 21,
            "M" to 22,
            "N" to 23,
            "O" to 24,
            "P" to 25,
            "Q" to 26,
            "R" to 27,
            "S" to 28,
            "T" to 29,
            "U" to 30,
            "V" to 31,
            "W" to 32,
            "X" to 33,
            "Y" to 34,
            "Z" to 35,
        )

        private val allowedCharacters = allowedCharsMap.keys.toTypedArray()
        private val allowedCharsLength = allowedCharacters.size
    }

    fun generateBankAccountNumber(input: Int) : String {
        var mutableInput = input
        val encodedString = StringBuilder()
        if (mutableInput == 0) {
            return allowedCharacters[0]
        }
        while (mutableInput > 0) {
            val key = allowedCharacters[mutableInput % allowedCharsLength]
            encodedString.append(allowedCharsMap[key])
            mutableInput /= allowedCharsLength
        }

        val bankAccountNumber = encodedString.reverse().toString()
        loggerComp.info("new bank account number generated, {}", bankAccountNumber)
        return bankAccountNumber.padStart(16, '0')
    }
}