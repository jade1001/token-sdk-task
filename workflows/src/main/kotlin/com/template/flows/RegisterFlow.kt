package com.template.flows

import co.paralleluniverse.fibers.Suspendable
import com.template.contracts.RegisterContract
import com.template.states.RegisterState
import net.corda.core.contracts.Command
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.flows.FinalityFlow
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.InitiatingFlow
import net.corda.core.flows.StartableByRPC
import net.corda.core.identity.Party
import net.corda.core.transactions.TransactionBuilder
import net.corda.core.utilities.ProgressTracker

@InitiatingFlow
@StartableByRPC
class RegisterFlow(val user: String, val registerParty: Party) : FlowLogic<Unit>() {
    override val progressTracker = ProgressTracker()
    @Suspendable
    override fun call() {
        val notary = serviceHub.networkMapCache.notaryIdentities.first()
        val outputState = RegisterState(user, registerParty)
        val command = Command(RegisterContract.Commands.Register(), ourIdentity.owningKey)
        val txBuilder = TransactionBuilder (notary).addOutputState(outputState, RegisterContract.ID).addCommand(command)
        val stx = serviceHub.signInitialTransaction(txBuilder)
        subFlow(FinalityFlow(stx))
    }
}