package MicroLab.com.beneficios


import MicroLab.com.DateTransformer
import MicroLab.com.LobbyModel
import MicroLab.com.LobbyWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.exceptions.UserException


class BenefitsWindow(owner: WindowOwner, model:BenefitsModel) : SimpleWindow<BenefitsModel>(owner,model){

    override fun addActions(actionsPanel: Panel) {
    }

    override fun createFormPanel(mainPanel: Panel) {
        title = "DigitalWallet - Benefits"
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with {
                text = "Nombre"
            }
            TextBox(it) with {
                bindTo("nombre")
                //width = 180
            }
            Panel(mainPanel) with {
                asHorizontal()
                Label(it) with {
                    text = "Fecha Desde"
                }
                TextBox(it) with {
                    withFilter {
                        val exp = "[0-9]{0,2}\\-?[0-9]{0,2}\\-?[0-9]{0,4}"
                        it.potentialTextResult.matches(exp.toRegex())
                    }
                    bindTo("fechaDesde").setTransformer(DateTransformer())
                    width = 180
                }
            }
            Panel(mainPanel) with {
                asHorizontal()
                Label(it) with {
                    text = "Fecha Hasta"
                }
                TextBox(it) with {
                    withFilter {
                        val exp = "[0-9]{0,2}-?[0-9]{0,2}-?[0-9]{0,4}"
                        it.potentialTextResult.matches(exp.toRegex())
                    }
                    bindTo("fechaHasta").setTransformer(DateTransformer())
                    width = 180
                }
            }
            Panel(mainPanel) with {
                asHorizontal()
                Label(it) with {
                    text = "Tipo de descuento"
                }
                Selector<Gift>(it) with {
                    bindTo("descuento")
                    bindItemsTo("types").adaptWithProp<Gift>("type")
                }

            }
            Panel(mainPanel) with {
                asHorizontal()
                Label(it) with {
                    text = "Importe del regalo o Descuento"
                }
                TextBox(it) with {
                    bindTo("importe")
                    width = 180
                }
            }
            Panel(mainPanel) with {
                asHorizontal()
                Label(it) with {
                    text = "Cantidad de operaciones"
                }
                TextBox(it) with {
                    bindTo("cantidadOperaciones")
                    width = 180
                }
            }
            Panel(mainPanel) with {
                asHorizontal()
                Label(it) with {
                    text = "Importe de cada operacion"
                }
                TextBox(it) with {
                    bindTo("importeOperacion")
                    width = 180
                }
            }
            Button(mainPanel) with {
                caption = "Agregar"
                onClick {
                    thisWindow.close()
                    try {
                        createBenefit()
                    }catch(e:IllegalStateException){
                        throw UserException(e.message)
                    }
                    catch(e:IllegalArgumentException){
                        throw UserException(e.message)
                    }


                }
            }
        }
    }

    private  fun createBenefit() = modelObject.createBenefit()

}