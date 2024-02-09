package MicroLab.com

import wallet.User

class LoginWrapper(var email: String = "", var password : String = "") {

    constructor(user: User) : this() {
        this.email = user.email
        this.password = user.password
    }
}