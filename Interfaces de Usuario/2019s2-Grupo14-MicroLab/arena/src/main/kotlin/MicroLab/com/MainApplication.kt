package MicroLab.com


import org.uqbar.arena.Application



fun main() = MainApplication().start()

class MainApplication : Application(){

    override fun createMainWindow(): LoginWindow {

        return LoginWindow(this, LoginModel())
    }
}