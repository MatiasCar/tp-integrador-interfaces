package org.Ventanas

import org.AppModel.LoginAppModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner


class LoginWindow (owner: WindowOwner, loginAppModel: LoginAppModel): SimpleWindow<LoginAppModel>(owner,loginAppModel) {
    override fun addActions(mainPanel: Panel) {

    }

    override fun createFormPanel(mainPanel: Panel) {
        title = "Medium"

        Label(mainPanel) with {
            text = "Email"
            alignCenter()
        }

        TextBox(mainPanel) with {
            width = 250
            bindTo("email")
        }

        Label(mainPanel) with {
            text = "Password"
            alignCenter()
        }

        PasswordField(mainPanel) with {
            bindTo("contraseña")
        }

        Button(mainPanel) with {
            caption = "Login"

        }
    }




}