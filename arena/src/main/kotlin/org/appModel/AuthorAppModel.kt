package org.appModel

import org.exceptions.NoSelectedException
import org.ui.Author
import org.ui.Note
import org.uqbar.commons.model.annotations.Observable

@Observable
class AuthorAppModel(author : Author, var system : MediumAppModel) {

    var id : String = ""
    var name : String = ""
    var email : String = ""
    var contraseña : String = ""
    var foto : String = ""
    var notas : MutableList<NotaAppModel> = mutableListOf() //notas mapeadas a AppModel
    var notaSeleccionada : NotaAppModel? = null


    init {
        id = author.id
        name = author.name
        email = author.email
        contraseña = author.password
        foto = author.photo
        notas = initNotas()

    }



    fun comprobarSeleccion(){
        if(notaSeleccionada ==null){
            throw NoSelectedException("No se ha seleccionado ninguna nota")
        }
    }

    fun deleteNote(){
        notaSeleccionada?.id?.let { system.removeNote(it) }
        notas = initNotas()
    }

    fun initNotas() : MutableList<NotaAppModel>{
      return system.searchNotesByAuthorId(id).map { NotaAppModel(it) }.toMutableList()
    }

    fun recargarNotas(){
        notas = initNotas()
    }



}