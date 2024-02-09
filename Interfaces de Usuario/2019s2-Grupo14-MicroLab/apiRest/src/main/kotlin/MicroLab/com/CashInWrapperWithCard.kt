package MicroLab.com

import wallet.Card
import wallet.CashInWithCard
import wallet.CreditCard
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CashInWrapperWithCard (var fromCVU: String = "", var amount: Double? = null, var cardNumber: String = "", var fullName: String = "",
                             var endDate: String = "", var securityCode: String = ""){

    var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    constructor(transfer: CashInWithCard) : this(){
        this.fromCVU = transfer.to.cvu
        this.amount = transfer.amount
        this.cardNumber = transfer.card.cardNumber
        this.endDate = transfer.card.endDate.toString()
        this.fullName = transfer.to.user.fullName()
        this.securityCode = transfer.card.securityCode
    }

    fun endDate1(s: String):LocalDate{
        return LocalDate.parse(s, formatter)
    }


    fun createCard() : Card{
        return CreditCard(this.cardNumber, this.fullName, this.endDate1(this.endDate), this.securityCode)
    }

}