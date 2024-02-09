package MicroLab.com.tablaModel

import MicroLab.com.exceptions.DeleteUserException
import MicroLab.com.modify.State
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException
import wallet.Account
import wallet.DigitalWallet
import wallet.User
import java.lang.IllegalArgumentException

@Observable
data class UserViewModel(val user : User?){
    var idCard: String? = user?.idCard
    var firstName: String? = user?.firstName
    var lastName: String? = user?.lastName
    var email: String? = user?.email
    var password: String? = user?.password
    var isAdmin: Boolean? = user?.isAdmin
    var account : Account? = user?.account
    var estados = listOf(
        State("Bloqueado"),
        State("Habilitado")
    )
    var bloqueado = estados[0]
    var habilitado = estados[1]


    fun model() = user
}

@Observable
class RegistroModel(val digitalWallet: DigitalWallet)  {
    var selectedUser: UserViewModel? = null
    var users = initUsers()

    private fun initUsers() = digitalWallet.users.map { UserViewModel(it) }.toMutableList()

    fun eliminarUsuario(){
        if(selectedUser == null) throw UserException("No se selecciono un usuario")
        if(selectedUser!!.account!!.balance == 0.0) {
            digitalWallet.deleteUser(selectedUser!!.model()!!)
        }else{
            throw UserException("no se puede eliminar usuario con saldo")
        }
        users = initUsers()
    }

    fun actualizarUsuario(){
        if("Bloqueado" == selectedUser!!.estados[0].name){
            digitalWallet.unblockAccount(selectedUser!!.model()!!.account!!)
        }else{
            digitalWallet.blockAccount(selectedUser!!.model()!!.account!!)
        }
    }

}