package org.ventanas

import org.appModel.AuthorAppModel
import org.appModel.MediumAppModel
import org.appModel.NotaAppModel
import org.exceptions.NoSelectedException
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.exceptions.UserException
import org.uqbar.lacar.ui.model.Action


class MainWindows(owner : WindowOwner, author : AuthorAppModel,var system : MediumAppModel) : SimpleWindow<AuthorAppModel>(owner, author){
    override fun addActions(p0: Panel?) {

        Button(p0) with { caption = "Add new Note"; onClick(Action { AddNoteWindows(thisWindow, NotaAppModel( null),system,modelObject).open() }) }

        Button(p0) with { caption = "Edit Note"; onClick(Action {
            try {
                modelObject.comprobarSeleccion()
                modelObject.notaSeleccionada?.guardarCopiaNota()
                modelObject.notaSeleccionada?.let { it1 -> EditNoteWindows(thisWindow, it1,system, modelObject).open() }
            }
            catch (e : NoSelectedException){
                throw UserException(e.message)
            }
        }) }

        Button(p0) with { caption = "Delete Note"; onClick(Action {
            try {
                modelObject.comprobarSeleccion()
                DeleteNoteDialog(owner,modelObject).open()
            }
            catch (e : NoSelectedException){
                throw UserException(e.message)
            }
             }) }
    }

    override fun createFormPanel(p0: Panel) {
       title =  "Author view"

    table<NotaAppModel>(p0){
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
            bindContentsTo("title")
        }
    }

        }






}