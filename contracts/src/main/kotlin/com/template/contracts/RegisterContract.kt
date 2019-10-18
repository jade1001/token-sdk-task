package com.template.contracts

import net.corda.core.contracts.CommandData
import net.corda.core.contracts.Contract
import net.corda.core.contracts.TypeOnlyCommandData
import net.corda.core.transactions.LedgerTransaction


class RegisterContract : Contract {
    companion object{
        const val ID = "com.template.contracts.RegisterContract"
    }

    override fun verify(tx: LedgerTransaction){

    }

    interface Commands: CommandData{
        class Action : Commands
        class Register : TypeOnlyCommandData(), Commands
    }
}