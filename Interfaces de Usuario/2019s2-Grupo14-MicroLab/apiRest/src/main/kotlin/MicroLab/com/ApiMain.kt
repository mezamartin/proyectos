package MicroLab.com

import data.DigitalWalletData
import io.javalin.Javalin
import io.javalin.core.util.RouteOverviewPlugin
import wallet.DigitalWallet


fun main(args: Array<String>) {
    val app = Javalin.create {
        it.defaultContentType = "application/json"
        it.registerPlugin(RouteOverviewPlugin("/routes"))
        it.enableCorsForAllOrigins()
    }
        .start(7000)

    val digitalWallet : DigitalWallet = DigitalWalletData.build()
    val controller = DigitalWalletController(digitalWallet)
    val transferController = TransferController(digitalWallet)

    app.get("/users") { ctx -> controller.getUsers(ctx) }

    //app.get("/users/:firstName") { ctx -> controller.getUser(ctx) }

    app.post("/register"){ctx -> controller.register(ctx) }

    app.post("/login"){ctx-> controller.login(ctx)}

    app.post("/transfer"){ctx->controller.transfer(ctx)}

    app.get("/accounts"){ctx->controller.getAccounts(ctx)}

    app.get("/transaction/:cvu"){ctx->transferController.getTransactionsFromCVU(ctx)}

    app.post("/cashIn"){ctx->controller.cashIn(ctx)}

    app.delete("/users/:cvu") { ctx -> controller.deleteUser(ctx) }

    app.get("/accounts/:cvu") { ctx -> controller.getCuenta(ctx) }

    app.get("/users/:email"){ctx->controller.getUserOfEmail(ctx)}

    app.patch("/users/:email"){ctx ->controller.updateUser(ctx)}

    app.post("/loyaltyDiscount"){ctx->transferController.loyaltyDiscount(ctx)}

    app.post("/loyaltyGift"){ctx->transferController.loyaltyGift(ctx)}

    app.get("/loyalty/:cvu"){ctx->transferController.getLoyalties(ctx)}

}