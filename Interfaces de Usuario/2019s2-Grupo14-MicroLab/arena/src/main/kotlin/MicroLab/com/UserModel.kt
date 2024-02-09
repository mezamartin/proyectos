package MicroLab.com

import MicroLab.com.exceptions.EmailException
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException
import wallet.*
import java.time.LocalDateTime
import kotlin.random.Random
import kotlin.random.nextInt


@Observable

class UserModel(val digitalWallet : DigitalWallet) {

    var nombre = ""
    var apellido = ""
    var dni = ""
    var email = ""
    var contraseña = ""
    var selected = ""
    var id : String = ""
    fun createAndAddUser() {
        if (!(digitalWallet.users.any { it.email == email })) {
            var user = User(getNextId(), nombre, apellido, email, contraseña, false)
            check(email.contains("@gmail.com")){"El email debe contener '@gmail.com'"}
            digitalWallet.register(user)
            var account = Account(user, DigitalWallet.generateNewCVU())
            digitalWallet.assignAccount(user, account)
            digitalWallet.addGift(InitialGift(account, 200.00, LocalDateTime.now()))

        } else {
            throw EmailException("This email has already exists")
        }
    }


        fun getNextId() : String{
            var random = Random.nextInt(900000000)+100000000
            return "$random"
        }
}





