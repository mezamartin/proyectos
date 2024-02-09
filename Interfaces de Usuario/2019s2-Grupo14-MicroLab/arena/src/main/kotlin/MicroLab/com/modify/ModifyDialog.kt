package MicroLab.com.modify

import MicroLab.com.tablaModel.UserViewModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class ModifyDialog(owner: WindowOwner, model: UserViewModel?) : Dialog<UserViewModel>(owner, model) {

    override fun createFormPanel(mainPanel: Panel) {
        Label(mainPanel) with{
            title = "DigitalWallet - Modificar Usuario"
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


        /*Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Numero de Documento:"
            }

            Label(it) with{
                text = "${email()}" // va el dni
            }
        }*/


        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Correo Electronico"
            }

            Label(it) with{
                width = 150
                text = "${email()}"
            }
        }


        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Estado:"
            }

            Selector<State>(it) with {
                bindTo("bloqueado")
                bindItemsTo("estados").adaptWithProp<State>("estado")
            }
        }

        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Cuenta CVU:"
            }

            Label(it)with{
                text = "${cuentaCVU()}"
            }
        }


        Panel(mainPanel)with{
            asHorizontal()
            Label(it) with{
                text = "Saldo:"
            }

            Label(it)with{
                text = "${saldo()}"
            }
        }

        Button(mainPanel) with{
            caption = "Modificar"
            onClick{
                accept()
            }
        }




    }

    private fun firstName() = modelObject.firstName
    private fun lastName() = modelObject.lastName
    private fun email() = modelObject.email
    private fun cuentaCVU() = modelObject.account!!.cvu
    private fun saldo() = modelObject.account!!.balance
}
