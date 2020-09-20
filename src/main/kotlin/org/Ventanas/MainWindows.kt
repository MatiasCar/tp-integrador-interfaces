package org.Ventanas

import org.AppModel.AuthorAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner


class MainWindows(owner : WindowOwner, author : AuthorAppModel) : SimpleWindow<AuthorAppModel>(owner, author){
    override fun addActions(p0: Panel?) {

    }

    override fun createFormPanel(p0: Panel?) {
       title =  "Ventana principal"
    }

}