package org.ventanas

import org.appModel.AuthorAppModel
import org.appModel.MediumAppModel
import org.appModel.NotaAppModel
import org.exceptions.TitleAlreadyExistException
import org.uqbar.arena.kotlin.extensions.caption
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.exceptions.UserException

class EditNoteWindows(owner: WindowOwner, notaAppModel: NotaAppModel, system : MediumAppModel, authorAppModel: AuthorAppModel) : FormNoteWindows(owner, notaAppModel,system, authorAppModel) {

    override fun addActions(p0: Panel?) {

        title = "Edit note windows"

        Button(p0) with {
            caption= "Aceptar"
            onClick {
                try {
                    system.comprobarExistenciaDeTitulo(modelObject.title)
                    modelObject.comprobarTituloVacio(modelObject.title)
                    close()

                } catch (e : TitleAlreadyExistException){
                    throw UserException(e.message)
                }
            }
        }

        Button(p0) with {
            caption = "Cancelar"
            onClick {
                modelObject.rollback()
                close() }
        }
    }
}