package MicroLab.com.Transfers

import MicroLab.com.LoginModel
import org.uqbar.commons.model.annotations.Observable
import wallet.*
import java.security.SecureRandom
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.random.Random

@Observable

class CashInModel(val digitalWallet: DigitalWallet, val userLogged : User){

var pan = ""
var nombre = ""
var apellido = ""
var vencimiento = ""
var clave = ""
var importe = ""

    fun cashIn() {
        var card: Card = createCard()
        digitalWallet.transferMoneyFromCard(userLogged.account!!.cvu, card,importe.toDouble())

    }

    fun createCard() : Card {
        return CreditCard(userLogged.idCard,userLogged.fullName(),LocalDate.now(),createSegurityCode())
    }

    fun createSegurityCode(): String{
        var random = Random(123)
        return "${random.nextInt(0,1000)}".padStart(3,'0')
    }
}