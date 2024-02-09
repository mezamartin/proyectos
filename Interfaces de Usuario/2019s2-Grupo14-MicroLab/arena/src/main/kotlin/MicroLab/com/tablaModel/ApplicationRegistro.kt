package MicroLab.com.tablaModel

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window

class ApplicationRegistro: Application() {
    override fun createMainWindow(): Window<*>? {
        return null//WindowRegistro(this, RegistroModel())
    }
}