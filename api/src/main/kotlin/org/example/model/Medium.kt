package org.example.model

import org.ui.Author
import org.ui.IdGenerator
import org.ui.bootstrap.getMediumSystem





class Medium {
    var system = getMediumSystem()



    fun register( name: String, email : String, password : String, photo : String) : Author{
        if(existeAuthor(name)){
            //levantar exception
        }
        val author = Author(IdGenerator().nextAuthorId(), name, email, password, photo)
        system.authors.add(author)
        return author;
    }


    fun existeAuthor(name : String) : Boolean{
       return system.authors.any {it.name == name}
    }
}