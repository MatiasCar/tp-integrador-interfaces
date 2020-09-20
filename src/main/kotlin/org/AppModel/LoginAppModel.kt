package org.AppModel

import org.ui.Author
import org.ui.MediumSystem
import org.uqbar.commons.model.annotations.Observable

@Observable
class LoginAppModel(val medium : MediumAppModel){

    var system : MediumSystem = medium.mediumSystem
    var email : String = ""
    var contraseña : String = ""

    fun login() : Author{
        return system.login(email, contraseña)
    }
}