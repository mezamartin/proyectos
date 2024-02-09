package MicroLab.com.eliminar

import MicroLab.com.tablaModel.UserViewModel
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.caption
import org.uqbar.arena.kotlin.extensions.text
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class EliminarUsuarioDialog(owner: WindowOwner, model: UserViewModel): Dialog<UserViewModel>(owner, model) {

    override fun createFormPanel(mainPanel: Panel) {
        title = "Eliminar usuario"

        Label(mainPanel) with{
            text = "Esta a punto de eliminar a ${modelObject.firstName} ${modelObject.lastName}" +
                    "¿Esta seguro?"
        }

        Panel(mainPanel)with{
            asHorizontal()

            Button(it) with{
                caption = "Cancelar"
                onClick{cancel()}
            }

            Button(it) with{
                caption = "Aceptar"
                onClick{accept()}
            }
        }
    }
}