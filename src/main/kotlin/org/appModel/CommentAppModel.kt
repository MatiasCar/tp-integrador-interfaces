package org.appModel

import org.ui.Author
import org.ui.Comment

class CommentAppModel (comentario : Comment) {

    var id: String = ""
    var author : Author? = null
    var body : String = ""

    init {
        this.id = comentario.id
        this.author = comentario.author
        this.body = comentario.body
    }
}