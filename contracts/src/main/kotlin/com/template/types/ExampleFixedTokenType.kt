package com.template.types

import com.r3.corda.lib.tokens.contracts.types.TokenType
import net.corda.core.serialization.CordaSerializable

@CordaSerializable
data class ExampleFixedTokenType(override val tokenIdentifier: String, override val fractionDigits: Int = 0)
    : TokenType(tokenIdentifier, fractionDigits) {

    override fun toString(): String = tokenIdentifier

    companion object {
        private val registry = mapOf(
                Pair("TokenType", ExampleFixedTokenType("PHP", 2)),
                Pair("TokenType", ExampleFixedTokenType("USD", 2))
        )


        fun getInstance(code: String): ExampleFixedTokenType {
            return registry[code] ?: throw IllegalArgumentException("$code doesn't exist.")
        }
    }
}