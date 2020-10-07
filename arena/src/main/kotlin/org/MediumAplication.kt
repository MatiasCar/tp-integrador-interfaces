package org


import org.appModel.LoginAppModel
import org.appModel.MediumAppModel
import org.ventanas.LoginWindow
import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window

class MediumAplication() : Application(){
    override fun createMainWindow(): Window<*> {
        return LoginWindow(this, LoginAppModel(MediumAppModel()), MediumAppModel())
    }

}

fun main(){
MediumAplication().start()
}