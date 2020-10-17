package org.example.controllers

import org.example.MediumTokenJWT
import org.ui.MediumSystem
import io.javalin.http.Context
import org.ui.NotFound
import org.ui.Note
import org.ui.UsedEmail
import org.ui.bootstrap.getMediumSystem

class UserController (val mediumToken : MediumTokenJWT, val mediumSystem : MediumSystem) {



    fun createUser(ctx : Context){
        try {
            val nuevoUsuario = ctx.bodyValidator<UserRegisterMapper>()
                .check({
                    it.name != null && it.email != null && it.password != null && it.photo != null
                }, "Invalid body : name, email, password or photo"
                )
                .get()
            val author = mediumSystem.registerAuthor(nuevoUsuario.name!!, nuevoUsuario.email!!, nuevoUsuario.password!!, nuevoUsuario.photo!!)
            ctx.header("Authorization", mediumToken.generateToken(author))
            ctx.status(201)
            ctx.json(mapOf("result" to "ok"))
        }
        catch (e : UsedEmail){
            ctx.status(400)
            ctx.json(
                mapOf(
                    "result" to "error",
                    "message" to e.message.toString()
                )
            )
        }

    }


    fun login(ctx : Context){
        val login = ctx.bodyValidator<UserLoginMapper>().check(
                {it.email != null && it.password != null}, "Invalid body"
        ).get()

        try {
            val usuario = mediumSystem.login(login.email!!, login.password!!)
            ctx.header("Authorization",mediumToken.generateToken(usuario))
            ctx.status(200)
            ctx.json(
                    mapOf("result" to "ok")
            )
        }
        catch (e : NotFound){
            ctx.status(404)
            ctx.json(
                    mapOf(
                            "result" to "error",
                            "message" to e.message.toString()
                    )
            )
        }
    }


    fun getUser(ctx : Context){
        val token = ctx.header("Authorization")
        val id = mediumToken.validate(token!!)
        val usuario = mediumSystem.getAuthor(id)
        ctx.status(201)
        ctx.json(
            UserInfoMapper(usuario.name, usuario.email, usuario.photo)
        )
    }


    fun getNotes(ctx : Context){
        val token = ctx.header("Authorization")
        val id = mediumToken.validate(token!!)
        val note = mediumSystem.notes.filter { it.author == mediumSystem.getAuthor(id) }
        ctx.status(201)
        ctx.json(
               note.map { NoteInfo(it.id,it.title, it.body, it.categories.toString(), it.author.name, it.comments) }
        )
    }
}