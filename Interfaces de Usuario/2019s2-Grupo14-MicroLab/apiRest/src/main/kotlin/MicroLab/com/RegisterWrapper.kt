package MicroLab.com

import wallet.User

class RegisterWrapper(var email : String = "", var firstName : String = "", var idCard: String = "",
                        var lastName : String = "", var password: String = ""){
    constructor(user: User) : this(){
        this.email = user.email
        this.firstName = user.firstName
        this.idCard = user.idCard
        this.lastName = user.lastName
        this.password = user.password
    }

    fun createUser() : User {
        return User(this.idCard,this.firstName,this.lastName,this.email,this.password,false)
    }


}