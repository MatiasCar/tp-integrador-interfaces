package org.ventanas

import org.appModel.AuthorAppModel
import org.appModel.MediumAppModel
import org.appModel.NotasAppModel
import org.exceptions.AlreadyExistException
import org.uqbar.arena.kotlin.extensions.caption
import org.uqbar.arena.kotlin.extensions.thisWindow
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.exceptions.UserException
import org.uqbar.lacar.ui.model.Action

class AddNoteWindows(owner: WindowOwner, notasAppModel: NotasAppModel, system : MediumAppModel, authorAppModel: AuthorAppModel) : FormNoteWindows(owner, notasAppModel, system, authorAppModel) {
    override fun addActions(p0: Panel?) {
       title = "Add note windows"
        Button(p0) with {
            caption = "Aceptar"
            onClick(Action {

                try {
                    system.comprobarExistenciaDeTitulo(modelObject.title)
                    modelObject.comprobarTituloVacio(modelObject.title)
                    system.mediumSystem.addNote( authorAppModel.id, modelObject.crearDraftNote())
                    authorAppModel.recargarNotas()
                    close()
                }
                catch (e : AlreadyExistException){
                    throw UserException(e.message)
                }

            })
        }


        Button(p0) with{
            caption = "Cancelar"
            onClick(Action { close() })
        }
    }
}