package org.Ventanas

import org.AppModel.AuthorAppModel
import org.AppModel.NotasAppModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.lacar.ui.model.Action


class MainWindows(owner : WindowOwner, author : AuthorAppModel) : SimpleWindow<AuthorAppModel>(owner, author){
    override fun addActions(p0: Panel?) {

        Button(p0) with { caption = "Add new Note"; onClick(Action {  }) }
        Button(p0) with { caption = "Edit Note"; onClick(Action {  }) }
        Button(p0) with { caption = "Delete Note"; onClick(Action {  }) }
    }

    override fun createFormPanel(p0: Panel) {
       title =  "Ventana principal"

    table<NotasAppModel>(p0){
        bindItemsTo("notas")
        bindSelectionTo("notaSeleccionada")
        visibleRows = 10
        column {
            title = "#"
            fixedSize = 50
            bindContentsTo("id")
        }
        column {
            title = "Title"
            weight = 50
            fixedSize = 400
            //align("center")
            bindContentsTo("title")
        }
    }

        }






}