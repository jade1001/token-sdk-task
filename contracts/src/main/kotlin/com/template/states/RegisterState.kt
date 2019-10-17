package com.template.states

import com.template.contracts.RegisterContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.ContractState
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party

@BelongsToContract(RegisterContract::class)
class RegisterState(val user : String, val party : Party, override val linearId: UniqueIdentifier = UniqueIdentifier()) : LinearState {
    override val participants : List<AbstractParty>
    get() = listOf(party)
}