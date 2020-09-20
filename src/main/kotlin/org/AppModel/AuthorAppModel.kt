package org.AppModel

import org.ui.Author
import org.uqbar.commons.model.annotations.Observable

@Observable
class AuthorAppModel(author : Author) {

    val id : String = author.id
    val name : String = author.name
    val email : String = author.email
    val contraseña : String = author.password
    val foto : String = author.photo


}