package MicroLab.com

import wallet.Account
import wallet.CashOutTransfer

class TransferWrapper(var fromCVU: String = "",var toCVU: String = "",var amount: Double? = null ) {
    constructor(transfer: CashOutTransfer) : this() {
        this.fromCVU = transfer.from.cvu
        this.toCVU = transfer.to.cvu
        this.amount = transfer.amount
    }
}

