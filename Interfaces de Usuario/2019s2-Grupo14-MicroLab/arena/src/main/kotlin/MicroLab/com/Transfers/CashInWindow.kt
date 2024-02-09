package MicroLab.com.Transfers

import MicroLab.com.LobbyModel
import MicroLab.com.LobbyWindow
import MicroLab.com.beneficios.BenefitsModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class CashInWindow(owner: WindowOwner, model: CashInModel) : SimpleWindow<CashInModel>(owner,model) {

    override fun addActions(actionsPanel: Panel) {
    }

    override fun createFormPanel(mainPanel: Panel) {
        title = "DigitalWallet - CashIn"
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with {
                text = "PAN"
            }
            TextBox(it) with {
                bindTo("pan")
                width = 180
            }
        }
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with {
                text = "Nombre"
            }
            TextBox(it) with {
                bindTo("nombre")
                width = 180
            }
        }
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with {
                text = "Apellido"
            }
            TextBox(it) with {
                bindTo("apellido")
                width = 180
            }
        }
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with {
                text = "Fecha de Vencimiento"
            }
            TextBox(it) with {
                bindTo("vencimiento")
                width = 180
            }
        }
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with {
                text = "CVV"
            }
            TextBox(it) with {
                bindTo("clave")
                width = 180
            }
        }
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with {
                text = "Importe"
            }
            TextBox(it) with {
                bindTo("importe")
                width = 180
            }
        }
        Button(mainPanel) with {
            caption = "Aceptar"
            onClick {
                close()
                cashIn()
                LobbyWindow(owner,
                    LobbyModel(thisWindow.modelObject.digitalWallet)).open()
            }
        }
    }

    private fun cashIn() = modelObject.cashIn()
}