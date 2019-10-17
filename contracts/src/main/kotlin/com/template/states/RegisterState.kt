package com.template.states

import com.template.contracts.RegisterContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.ContractState
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party

@BelongsToContract(RegisterContract::class)
data class RegisterState(val user : String, val party : Party) : ContractState {
    override val participants : List<AbstractParty>
    get() = listOf(party)
}