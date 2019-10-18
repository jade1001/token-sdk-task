package com.template.types

import com.r3.corda.lib.tokens.contracts.types.TokenType
import jdk.nashorn.internal.parser.Token
import javax.persistence.Column

data class MyToken<T>(override val tokenIdentifier: String,
                      override val fractionDigits: Int = 0) : TokenType(tokenIdentifier, fractionDigits){
    override fun toString(): String = tokenIdentifier

}