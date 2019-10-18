package com.template.states

import com.r3.corda.lib.tokens.contracts.types.TokenType
import com.template.contracts.RegisterContract
import net.corda.core.contracts.Amount
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party
import java.sql.Timestamp
import java.time.format.DateTimeFormatter

@BelongsToContract(RegisterContract::class)
class RegisterState(val user: String,
                    var wallet: List<Amount<TokenType>> = listOf((Amount.zero(TokenType("PHP", 2))),
                            (Amount.zero(TokenType("USD", 2)))),
                    override val participants : List<AbstractParty>,
                    override val linearId: UniqueIdentifier = UniqueIdentifier()) : LinearState




