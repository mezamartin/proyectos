package MicroLab.com

import MicroLab.com.exceptions.EmailException
import MicroLab.com.tablaModel.RegistroModel
import MicroLab.com.tablaModel.WindowRegistro
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.exceptions.UserException
import wallet.DigitalWallet


class UserWindow(owner:WindowOwner, model: UserModel): SimpleWindow<UserModel>(owner,model) {
    override fun addActions(actionsPanel: Panel?) {
    }

    override fun createFormPanel(mainPanel: Panel?) {

        title = "DigitalWallet - Agregar Usuario"
        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with {
                text = "Nombre"
            }
            TextBox(it) with {
                bindTo("nombre")
            }
        }

        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with {
                text = "Apellido"
            }
            TextBox(it) with {
                bindTo("apellido")
            }
        }

        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with {
                text = "DNI"
            }
            NumericField(it) with {
                bindTo("dni")
            }
        }

        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with {
                text = "Correo Electronico"
            }
            TextBox(it) with {
                bindTo("email")
            }
        }


        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with {
                text = "Contraseña"
            }
            PasswordField(it) with {
                bindTo("contraseña")
            }
        }

        Panel(mainPanel) with {
            asHorizontal()
            width = 250
            Label(it) with {
                text = "Es Administrador?"
            }

            CheckBox(it) with {
                bindTo("selected")
            }
        }
        Button(mainPanel) with {
            caption = "Agregar"
            onClick{
                try {
                    createAndAddUser()
                    close()
                    WindowRegistro(thisWindow, RegistroModel(thisWindow.modelObject.digitalWallet)).open()
                }catch (e:EmailException){
                    throw UserException(e.message)
                }catch(e:IllegalStateException){
                    throw UserException(e.message)
                }
            }
        }
        Button(mainPanel) with {
            caption= "Cancelar"
            onClick {
                close()
                WindowRegistro(thisWindow, RegistroModel(thisWindow.modelObject.digitalWallet)).open()
            }
        }

    }
    fun createAndAddUser() = modelObject.createAndAddUser()
}