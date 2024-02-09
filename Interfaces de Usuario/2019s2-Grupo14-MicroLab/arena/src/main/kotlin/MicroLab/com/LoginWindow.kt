package MicroLab.com

import MicroLab.com.tablaModel.RegistroModel
import MicroLab.com.tablaModel.WindowRegistro
import org.uqbar.arena.aop.windows.`DialogTrait$class`.onAccept
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.exceptions.UserException
import wallet.DigitalWallet
import wallet.LoginException


class LoginWindow(owner:WindowOwner, model:LoginModel) : SimpleWindow<LoginModel>(owner,model) {


    override fun addActions(actionsPanel: Panel) {
    }

    override fun createFormPanel(mainPanel: Panel) {
        title = "DigitalWallet - Login"
        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with {
                text = "Correo Electronico"
            }
            TextBox(it) with {
                bindTo("stre")
                width = 180
            }
        }

        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with {
                text = "Contraseña"
            }
            PasswordField(it) with {
                bindTo("strp")
                width = 180
            }
        }

       // agregarUsuarioAdmin()
        Button(mainPanel) with {
            caption = "Ingresar"
            onClick {

                        try {
                            login()
                            cleanData()
                            this@LoginWindow.close()
                            LobbyWindow(thisWindow,LobbyModel(thisWindow.modelObject.digitalWallet)).open()


                        } catch (e: LoginException) {
                            throw UserException(e.message)
                        }
                    }
        }
    }

    private fun login() = modelObject.login()
    private fun cleanData() = modelObject.cleanData()//data

}