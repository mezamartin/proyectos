package MicroLab.com

import wallet.User

class UpdateUser(var email : String = "", var firstName : String = "",var lastName : String = ""){
    constructor(user: User) : this(){
        this.email = user.email
        this.firstName = user.firstName
        this.lastName = user.lastName
    }

}