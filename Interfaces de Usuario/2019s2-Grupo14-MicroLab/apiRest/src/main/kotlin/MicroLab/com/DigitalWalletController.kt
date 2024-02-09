package MicroLab.com

import data.DigitalWalletData
import io.javalin.http.*
import io.javalin.http.Handler

import wallet.*
import java.time.LocalDateTime

class DigitalWalletController(digitalWallet: DigitalWallet){

    val digitalWallet = digitalWallet
    var userLogged: MutableList<User> = mutableListOf<User>()

    fun getUsers(ctx:Context){
        ctx.json(digitalWallet.users.map{RegisterWrapper(it)})
    }

    fun getAccounts(ctx:Context){
        ctx.json(digitalWallet.accounts.map { AccountWrapper(it) })
    }


    fun deleteUser(ctx: Context){
        val user = digitalWallet.users.firstOrNull{ it.account!!.cvu == ctx.pathParam("cvu")}
        try {
            digitalWallet.deleteUser(user!!)
            ctx.status(204)
            ctx.json("user Deleted")
        }catch(exception : IllegalArgumentException){
            ctx.status(400)
            ctx.json(Handler(400,"Bad Request","User With founds"))
        }
    }


    fun updateUser(ctx: Context) {
        var user = digitalWallet.users.find{ it.email == ctx.pathParam("email")}
        var userUpdate = ctx.body<UpdateUser>()
        user!!.email = userUpdate.email
        user!!.firstName = userUpdate.firstName
        user!!.lastName = userUpdate.lastName
        ctx.json(RegisterWrapper(user.email,user.firstName,user.idCard,user.lastName,user.password))
    }
    /*fun getSaldo(ctx: Context){
        val user = digitalWallet.users.firstOrNull{ it.account!!.cvu == ctx.pathParam("cvu")}
                    ?: throw NotFoundResponse("Invalid cvu")
        ctx.json(BasicUserWrapper(user.account!!.balance))
    }*/

    fun getCuenta(ctx: Context){
        val account = digitalWallet.accounts.firstOrNull{ it.cvu == ctx.pathParam("cvu")}
            ?: throw NotFoundResponse("Invalid cvu")
        ctx.json(BasicUserWrapper(account.balance,account.cvu))
    }

    fun getUser(ctx: Context){
        val user = digitalWallet.users.firstOrNull{it.firstName == ctx.pathParam("firstName")}
            ?: throw NotFoundResponse("Invalid username")
        ctx.json(UserWrapper(user.email, user.firstName, user.idCard, user.lastName, user.password))
    }

    fun getUserOfEmail(ctx:Context) {
        val user = digitalWallet.users.firstOrNull { it.email == ctx.pathParam("email") }
            ?: throw NotFoundResponse("Invalid email")
        ctx.json(UserWrapper(user.email, user.firstName, user.idCard, user.lastName, user.password))
    }

    fun register(ctx: Context){
        val newUser = ctx.body<RegisterWrapper>()
        ctx.bodyValidator<RegisterWrapper>()
            .check({it.email.contains("@gmail.com") && it.email.length > 10},newUser.email +" El formato de ser 'user@gmail.com'")
            .check({it.idCard.length == 10},newUser.idCard +" debe contener 10 digitos")
            .get()
        try{
            val user = newUser.createUser()
            digitalWallet.register(user)
                val acc = Account(user,DigitalWallet.generateNewCVU())
            digitalWallet.assignAccount(user,acc)
            digitalWallet.addGift(InitialGift(acc,200.00, LocalDateTime.now()))
            ctx.json(newUser)
            ctx.status(201)
        }catch(exception : IllegalArgumentException){
            ctx.status(400)
            ctx.json(Handler(400,"Bad Request","Credit card or e-mail already registered"))
        }
    }

    fun login(ctx: Context){
        val logWrapper = ctx.bodyAsClass(LoginWrapper::class.java)
        try{
            digitalWallet.login(logWrapper.email,logWrapper.password)
            ctx.json("login success")
        }catch (exception : LoginException){
            ctx.status(400)
            ctx.json(Handler(400,"Bad Request","Wrong email or password"))
        }
    }

    fun transfer(ctx: Context){
        val transferWrapper = ctx.body<TransferWrapper>()
        ctx.bodyValidator<TransferWrapper>()
            .check({it.fromCVU.length == 9}, "El cvu debe contener 9 digitos")
            .check({it.toCVU.length == 9}, "El cvu debe contener 9 digitos")
            .check({ it.amount!! > 0 }, "tiene que ser positivo")
            .get()
        try{
            digitalWallet.transfer(transferWrapper.fromCVU,
                                    transferWrapper.toCVU,transferWrapper.amount!!)

            ctx.json("Transfer success")
        }catch (exception: NoMoneyException){
            ctx.status(400)
            ctx.json(Handler(400,"Bad Request","Insufficcient balance"))

        }catch(exception: NoSuchElementException){
            ctx.status(400)
            ctx.json(Handler(400,"Bad Request","invalid cvu"))  
        }
    }

    fun cashIn(ctx: Context){
        val cashInWrapperWithCard = ctx.body<CashInWrapperWithCard>()
        ctx.bodyValidator<CashInWrapperWithCard>()
            .check({it.amount!! > 0 }, "amount tiene que ser positivo")
            .check({it.cardNumber.length == 19}, "card number son 16 digitos en formato de 4")
            .check({it.fromCVU.length!! == 9 }, "tiene que ser positivo")
            .get()
        try{
            digitalWallet.transferMoneyFromCard(cashInWrapperWithCard.fromCVU,
                cashInWrapperWithCard.createCard(), cashInWrapperWithCard.amount!!)

        }catch(exception : BlockedAccountException){
            throw UnauthorizedResponse("The user is blocked")


        }
        catch(exception : SaldoNegativoException){
            ctx.status(400)
            ctx.json(Handler(400,"Bad Request", "Saldo incorrecto"))
        }
        catch(exception : InvalidCVUException){
            ctx.status(400)
            ctx.json(Handler(400,"Bad Request", "CVU invalido"))
        }
        catch(exception : InvalidCardNumberException){
            ctx.status(400)
            ctx.json(Handler(400,"Bad Request", "Numero de tarjeta invalido"))
        }
    }

}