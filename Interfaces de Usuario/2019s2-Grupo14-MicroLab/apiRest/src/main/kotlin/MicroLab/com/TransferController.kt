package MicroLab.com

import data.DigitalWalletData
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder
import io.javalin.core.util.RouteOverviewPlugin
import io.javalin.http.Context
import io.javalin.http.NotFoundResponse

import wallet.Account
import wallet.DigitalWallet

class TransferController(digitalWallet: DigitalWallet) {

    val digitalWallet = digitalWallet

    fun getTransactionsFromCVU(ctx: Context) {
        try {
            ctx.json(digitalWallet.accountByCVU(ctx.pathParam("cvu")).transactions.map { TransactionWrapper(it) })
        } catch (exception: CvuException) {
            ctx.status(400)
            ctx.json(Handler(400, "Bad Request", "cvu does not exist"))
        }
    }

    fun loyaltyDiscount(ctx: Context){
        var loyaltyWrapper = ctx.body<LoyaltyWrapper>()
        ctx.bodyValidator<LoyaltyWrapper>()
            .check({it.amount!! > 0.0}, loyaltyWrapper.amount.toString() + " debe ser mayor a 0")
            .check({it.cantTransaction!! > 0.0}, loyaltyWrapper.cantTransaction.toString() + " debe ser mayor a 0")
            .check({it.minTransaction!! > 0}, loyaltyWrapper.minTransaction.toString() + "debe ser mayor a 0")

        val loyalty = loyaltyWrapper.createLoyaltyDiscount()
        digitalWallet.addLoyalty(loyalty)
        ctx.json("loyalty added")
    }

    fun loyaltyGift(ctx: Context){
        var loyaltyWrapper = ctx.body<LoyaltyWrapper>()
        ctx.bodyValidator<LoyaltyWrapper>()
            .check({it.amount!! > 0.0}, loyaltyWrapper.amount.toString() + " debe ser mayor a 0")
            .check({it.cantTransaction!! > 0.0}, loyaltyWrapper.cantTransaction.toString() + " debe ser mayor a 0")
            .check({it.minTransaction!! > 0}, loyaltyWrapper.minTransaction.toString() + "debe ser mayor a 0")

        val loyalty = loyaltyWrapper.createLoyaltyGift()
        digitalWallet.addLoyalty(loyalty)
        ctx.json("loyalty added")
    }

    fun getLoyalties(ctx: Context){

        val acc = digitalWallet.accountByCVU(ctx.pathParam("cvu"))
        ctx.json(acc.appliedLoyalties.map { LoyaltyWrapper() })
    }

}






