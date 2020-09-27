package org.AppModel

import org.ui.Author
import org.ui.MediumSystem
import org.ui.Note
import org.uqbar.commons.model.annotations.Observable

@Observable
class AuthorAppModel(author : Author, var system : MediumSystem) {

    var id : String = ""
    var name : String = ""
    var email : String = ""
    var contraseña : String = ""
    var foto : String = ""
    var notasDelModelo : List<Note> = mutableListOf() //notas que vienen del modelo
    var notas : MutableList<NotasAppModel> = mutableListOf() //notas mapeadas a AppModel
    var notaSeleccionada : NotasAppModel? = null


    init {
        id = author.id
        name = author.name
        email = author.email
        contraseña = author.password
        foto = author.photo
        notasDelModelo = system.searchNotesByAuthorId(id)
        notas = notasDelModelo.map { NotasAppModel(it) }.toMutableList()
    }




}