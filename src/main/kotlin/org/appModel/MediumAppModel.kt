package org.appModel

import org.exceptions.TitleAlreadyExistException
import org.ui.Note
import org.ui.bootstrap.getMediumSystem


class MediumAppModel () {

    val mediumSystem = getMediumSystem()
    var autores = mediumSystem.authors
    var notas = mediumSystem.notes



    fun comprobarExistenciaDeTitulo( titulo : String){
        var rta : Boolean = false
        for( nota in notas){
            rta = rta or (nota.title == titulo)
        }
        if(rta){
            throw TitleAlreadyExistException("Ya existe una nota llamada $titulo")
        }
    }


    fun removeNote(note : String){
        mediumSystem.removeNote(note)
    }

    fun searchNotesByAuthorId(author : String) : List<Note>{
     return mediumSystem.searchNotesByAuthorId(author)
    }


}