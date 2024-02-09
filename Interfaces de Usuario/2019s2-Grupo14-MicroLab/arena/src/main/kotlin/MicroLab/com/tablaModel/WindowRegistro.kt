package MicroLab.com.tablaModel
import MicroLab.com.LobbyModel
import MicroLab.com.LobbyWindow
import MicroLab.com.UserModel
import MicroLab.com.UserWindow
import MicroLab.com.eliminar.EliminarUsuarioDialog
import MicroLab.com.exceptions.DeleteUserException
import MicroLab.com.modify.ModifyDialog
import MicroLab.com.verUsuario.VerUsuarioDialog
import org.omg.CORBA.UserException
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class WindowRegistro: SimpleWindow<RegistroModel> {

    constructor(owner: WindowOwner, model: RegistroModel) : super(owner, model)

    override fun addActions(mainPanel: Panel) {

    }

    override fun createMainTemplate(mainPanel: Panel) {
        title = "fjdjkjs"

        mainPanel.asHorizontal()
        makeSelectedUser(mainPanel)
    }

    private fun makeSelectedUser(owner: Panel) {
        Panel(owner) with { it ->
            Label(it) with {
                title = "DigitalWallet - Administracion"
            }

            table<UserViewModel>(it) with {
                bindItemsTo("users")
                bindTo("selectedUser")
                column {
                    title = "Nombre"
                    fixedSize = 150
                    bindContentsTo("firstName")
                }
                column {
                    title = "Apellido"
                    fixedSize = 150
                    bindContentsTo("lastName")
                }
                column {
                    title = "Usuario"
                    fixedSize = 150
                    bindContentsTo("email")
                }

            }

            Panel(it) with {
                asHorizontal()
                Button(it) with {
                    caption = "Ver"
                    onClick{
                        VerUsuarioDialog(thisWindow, thisWindow.modelObject.selectedUser!!).open()
                    }
                }

                Button(it) with {
                    caption = "Agregar"
                    onClick {
                        close()
                        UserWindow(thisWindow, UserModel(thisWindow.modelObject.digitalWallet)).open()
                    }
                }

                Button(it) with {
                    caption = "Modificar"
                    onClick {
                        ModifyDialog(thisWindow, thisWindow.modelObject.selectedUser)with{
                            onAccept{actualizarUsuario()}
                            open()
                        }
                    }
                }

                Button(it) with {
                    caption = "Eliminar"
                    onClick {
                        EliminarUsuarioDialog(thisWindow, thisWindow.modelObject.selectedUser!!) with{
                            onAccept {
                               eliminarUsuario()
                            }
                            open()
                        }
                    }
                }

                Button(it) with{
                    caption = "Atras"
                    onClick{
                        close()
                        LobbyWindow(thisWindow, LobbyModel(thisWindow.modelObject.digitalWallet)).open()
                    }
                }

            }
        }
    }

    override fun createFormPanel(mainPanel: Panel) {
    }

    private fun actualizarUsuario() = modelObject.actualizarUsuario()
    private fun eliminarUsuario() = modelObject.eliminarUsuario()
}