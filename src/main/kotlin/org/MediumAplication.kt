package org


import org.AppModel.LoginAppModel
import org.AppModel.MediumAppModel
import org.Ventanas.LoginWindow
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window

class MediumAplication() : Application(){
    override fun createMainWindow(): Window<*> {
        return LoginWindow(this, LoginAppModel(MediumAppModel()))
    }

}

fun main(){
MediumAplication().start()
}