package MicroLab.com

import wallet.DiscountGiftStrategy
import wallet.FixedGiftStrategy
import wallet.LoyaltyGift
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LoyaltyWrapper(var name: String="",var fromDate: String="",var toDate: String="",var amount:Double? = null,
                     var minTransaction: Double? = null, var cantTransaction: Int? = 0) {

    var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    constructor(loyalty : LoyaltyWrapper) : this(){
        this.name = loyalty.name
        this.fromDate = loyalty.fromDate
        this.toDate = loyalty.toDate
        this.amount = loyalty.amount
        this.minTransaction = loyalty.minTransaction
        this.cantTransaction = loyalty.cantTransaction
    }

    fun toDate(s:String): LocalDate{
        return LocalDate.parse(s,formatter)
    }

    fun createLoyaltyDiscount() : LoyaltyGift{
        return LoyaltyGift(this.name,DiscountGiftStrategy(this.amount!!),this.cantTransaction!!,
                            this.minTransaction!!,this.toDate(this.fromDate),this.toDate(this.toDate))
    }

    fun createLoyaltyGift() : LoyaltyGift{
        return LoyaltyGift(this.name,FixedGiftStrategy(this.amount!!),this.cantTransaction!!,
                            this.minTransaction!!,this.toDate(this.fromDate),this.toDate(toDate))

    }
}
