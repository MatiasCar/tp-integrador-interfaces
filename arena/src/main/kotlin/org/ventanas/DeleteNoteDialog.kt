package org.ventanas

import org.appModel.AuthorAppModel
import org.uqbar.arena.kotlin.extensions.caption
import org.uqbar.arena.kotlin.extensions.text
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.lacar.ui.model.Action

class DeleteNoteDialog(owner: WindowOwner, authorAppModel: AuthorAppModel) : Dialog<AuthorAppModel>(owner,authorAppModel) {
    override fun createFormPanel(dialogoDelete: Panel?) {
        Label(dialogoDelete) with { text = "Realmente quiere borrar la nota "+'"'+ (modelObject.notaSeleccionada?.title)+'"'}

        Button(dialogoDelete) with {
           caption = "Aceptar"
            onClick(Action { modelObject.deleteNote()
            close()})
        }

        Button(dialogoDelete) with {
            caption = "Cancelar"
            onClick(Action{close()})
        }
    }



}