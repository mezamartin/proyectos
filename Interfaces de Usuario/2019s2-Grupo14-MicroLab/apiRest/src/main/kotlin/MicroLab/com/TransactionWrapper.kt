package MicroLab.com

import wallet.Transactional
import java.time.LocalDateTime


class TransactionWrapper(var amount: Double? = null,var date: LocalDateTime? = null, var description: String = "",
                         var fullDescription: String = "", var cashOut: Boolean? = null){

    constructor(transaction : Transactional): this(){
        this.amount = transaction.amount
        this.date = transaction.dateTime
        this.description = transaction.description()
        this.fullDescription = transaction.fullDescription()
        this.cashOut = transaction.isCashOut()
    }

}
