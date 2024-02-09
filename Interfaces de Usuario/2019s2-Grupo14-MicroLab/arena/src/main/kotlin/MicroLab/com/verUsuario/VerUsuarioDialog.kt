package MicroLab.com.verUsuario

import MicroLab.com.modify.State
import MicroLab.com.tablaModel.UserViewModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class VerUsuarioDialog(owner: WindowOwner, model: UserViewModel):Dialog<UserViewModel>(owner,model) {


    override fun createFormPanel(mainPanel: Panel) {
        Label(mainPanel) with{
            title = "DigitalWallet - Ver Usuario"
        }

        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Nombre:"
            }

            Label(it) with{
                text = "${firstName()}"
            }
        }

        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Apellido:"
            }

            Label(it) with{
                text = "${lastName()}"
            }
        }


        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Correo Electronico:"
            }

            Label(it) with{
                text = "${email()}"
            }
        }

       /* Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Estado:"
            }

            Selector<State>(it) with {
                bindTo("bloqueado")
                bindItemsTo("estados").adaptWithProp<State>("estado")
            }
        }*/

        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Cuenta CVU:"
            }

            Label(it) with{
                text = "${cuentaCVU()}"
            }
        }


        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Saldo:"
            }

            Label(it) with{
                text = "${saldo()}"
            }
        }

        Button(mainPanel) with{
            caption = "Cerrar"
            onClick{
                cancel()
            }
        }
    }

    private fun firstName() = modelObject.firstName
    private fun lastName() = modelObject.lastName
    private fun email() = modelObject.email
    private fun cuentaCVU() = modelObject.account!!.cvu
    private fun saldo() = modelObject.account!!.balance



}