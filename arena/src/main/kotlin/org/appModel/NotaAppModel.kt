package org.appModel

import org.exceptions.EmptyTitleFieldExceptionTitle
import org.ui.Author
import org.ui.Comment
import org.ui.DraftNote
import org.ui.Note
import org.uqbar.commons.model.annotations.Observable

@Observable
class NotaAppModel(nota: Note?) {

    var id: String = ""
    var title : String = ""
    var body : String = ""
    var categories : String = ""
    var categoriasDeModelo : List<String> = mutableListOf()
    var author : Author? = null
    var comments : MutableList<CommentAppModel> = mutableListOf()
    var comentariosNota : MutableList<Comment> = mutableListOf()


    var copyTitle : String = ""
    var copyBody : String = ""
    var copyCategories : String = ""

    init {
        if (nota != null) {
            id = nota.id
            title = nota.title
            body = nota.body
            categories = nota.categories.toString()
            author = nota.author
            comentariosNota = nota.comments
            comments = mapComentarios()
            categoriasDeModelo = nota.categories
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
            throw EmptyTitleFieldExceptionTitle("No se ha escrito ningun titulo")
        }
    }

    fun guardarCopiaNota() {
        copyTitle = title
        copyBody = body
        copyCategories = categories
    }

    fun rollback(){
        title = copyTitle
        body = copyBody
        categories = copyCategories
    }
}

