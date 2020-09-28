package org.appModel

import org.exceptions.EmptyFieldException
import org.ui.Author
import org.ui.Comment
import org.ui.DraftNote
import org.ui.Note
import org.uqbar.commons.model.annotations.Observable

@Observable
class NotasAppModel(nota: Note?) {

    var id: String = ""
    var title : String = ""
    var body : String = ""
    var categories : String = ""
    var author : Author? = null
    var comments : MutableList<CommentAppModel> = mutableListOf()
    var comentariosNota : MutableList<Comment> = mutableListOf()

    init {
        if (nota != null) {
            id = nota.id
            title = nota.title
            body = nota.body
            categories = nota.categories.toString()
            author = nota.author
            comentariosNota = nota.comments
            comments = mapComentarios()
        }
    }


    fun mapComentarios() : MutableList<CommentAppModel>{
        return comentariosNota.map { CommentAppModel(it) }.toMutableList()
    }

    fun crearDraftNote() : DraftNote{
        return DraftNote(title, body, categories)
    }

    fun comprobarTituloVacio(titulo: String) {
        if(titulo == ""){
            throw EmptyFieldException("No se ha escrito ningun titulo")
        }
    }
}

