package org.example.controllers

import org.example.MediumTokenJWT
import org.ui.MediumSystem
import io.javalin.http.Context
import org.example.exceptions.UserNameExistException

class UserController (val system : MediumSystem , val mediumToken : MediumTokenJWT) {


    fun createUser(ctx : Context){
        try {
            val nuevoUsuario = ctx.bodyValidator<UserRegisterMapper>()
                .check({
                    it.name != null && it.email != null && it.password != null && it.photo != null
                }, "Invalid body : name, email, password or photo"
                )
                .get()
            val author = system.registerAuthor(nuevoUsuario.name!!, nuevoUsuario.email!!, nuevoUsuario.password!!, nuevoUsuario.photo!!)
            ctx.header("Authorization", mediumToken.generateToken(author))
            ctx.status(201)
            ctx.json(mapOf("result" to "ok"))
        }
        catch (e : UserNameExistException){
            ctx.status(400)
            ctx.json(
                mapOf(
                    "result" to "error",
                    "message" to e.message.toString()
                )
            )
        }

    }

}