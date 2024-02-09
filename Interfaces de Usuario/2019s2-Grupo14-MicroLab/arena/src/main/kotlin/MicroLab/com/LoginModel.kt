package MicroLab.com


import data.DigitalWalletData
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.annotations.Observable
import wallet.Account
import wallet.DigitalWallet
import wallet.LoginException
import wallet.User
import kotlin.random.Random


@Observable

class LoginModel(){
    var digitalWallet = DigitalWalletData.build()
    var stre = ""
    var strp = ""
    fun cleanData(){
        stre = ""
        strp = ""
    }

    fun login(){
        digitalWallet.login(stre, strp)
    }

}

