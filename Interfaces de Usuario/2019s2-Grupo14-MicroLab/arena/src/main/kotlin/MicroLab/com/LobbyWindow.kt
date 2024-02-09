package MicroLab.com

import MicroLab.com.Transfers.CashInModel
import MicroLab.com.Transfers.CashInWindow
import MicroLab.com.beneficios.BenefitsModel
import MicroLab.com.beneficios.BenefitsWindow
import MicroLab.com.tablaModel.RegistroModel
import MicroLab.com.tablaModel.WindowRegistro
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.caption
import org.uqbar.arena.kotlin.extensions.thisWindow
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.exceptions.UserException

class LobbyWindow(owner:WindowOwner, model:LobbyModel) : SimpleWindow<LobbyModel>(owner,model) {

    override fun addActions(actionsPanel: Panel) {
    }

    override fun createFormPanel(mainPanel: Panel) {
        title = "DigitalWallet - Lobby"
        Panel(mainPanel) with {
            asHorizontal()
            Button(mainPanel) with {
                caption = "Administracion"
                onClick {
                    thisWindow.close()
                    WindowRegistro(thisWindow, RegistroModel(thisWindow.modelObject.digitalWallet)).open()
                }
            }

            Button(mainPanel) with {
                caption = "Beneficios"
                onClick {
                    try{
                        BenefitsWindow(thisWindow, BenefitsModel(thisWindow.modelObject.digitalWallet)).open()
                    }catch (e:UserException){
                        throw UserException(e.message)
                    }

                }
            }
        }
    }
}