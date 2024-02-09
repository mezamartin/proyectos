package MicroLab.com

import wallet.Account
import wallet.DigitalWallet
import wallet.User



class AccountWrapper(var cvu: String ="", var balance: Double? =null, var user:RegisterWrapper?=null) {

    constructor(account: Account) : this() {
        this.cvu = account.cvu
        this.balance = account.balance
        this.user = RegisterWrapper(
            account.user.email, account.user.firstName, account.user.idCard,
            account.user.lastName, account.user.password
        )

    }

}