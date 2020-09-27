package org.appModel

import org.ui.Author
import org.ui.Comment
import org.ui.Note
import org.uqbar.commons.model.annotations.Observable

@Observable
class NotasAppModel (nota : Note) {

    var id: String = ""
    var title : String = ""
    var body : String = ""
    var categories : List<String> = mutableListOf()
    var author : Author? = null
    var comments : MutableList<CommentAppModel> = mutableListOf()
    var comentariosNota : MutableList<Comment> = mutableListOf()

    init {
        id = nota.id
        title = nota.title
        body = nota.body
        categories = nota.categories
        author = nota.author
        comentariosNota = nota.comments
        comments = mapComentarios()
    }


    fun mapComentarios() : MutableList<CommentAppModel>{
        return comentariosNota.map { CommentAppModel(it) }.toMutableList()
    }
}

