package org.ventanas

import org.appModel.AuthorAppModel
import org.appModel.LoginAppModel
import org.appModel.MediumAppModel
import org.ui.Author
import org.ui.NotFound
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.exceptions.UserException
import org.uqbar.lacar.ui.model.Action


class LoginWindow (owner: WindowOwner, loginAppModel: LoginAppModel, var system : MediumAppModel): SimpleWindow<LoginAppModel>(owner,loginAppModel) {
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
            onClick(Action { try{
                var author : Author = modelObject.system.login( modelObject.email, modelObject.contraseña)
                thisWindow.close()
                MainWindows(owner, AuthorAppModel(author, system) ,system).open()

            }
            catch (e : NotFound){
                throw UserException(e.message)
            }})
        }
    }




}