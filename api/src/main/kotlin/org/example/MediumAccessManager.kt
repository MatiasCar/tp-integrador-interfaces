package org.example

import io.javalin.core.security.AccessManager
import io.javalin.core.security.Role
import io.javalin.http.Context
import io.javalin.http.Handler
import io.javalin.http.UnauthorizedResponse
import org.example.exceptions.TokenNotFoundException
import org.example.exceptions.UserNotFoundException
import org.example.model.Medium
import org.ui.Author

class MediumAccessManager(val tokenJWT: MediumTokenJWT, val medium: Medium): AccessManager{
    override fun manage(handler: Handler, ctx : Context, roles : MutableSet<Role>) {
        val token = ctx.header("Authorization")
        when{
            token == null && roles.contains(Roles.ANYONE) -> handler.handle(ctx)
            token == null -> throw UnauthorizedResponse("Token no encontrado")
            roles.contains(Roles.ANYONE) -> handler.handle(ctx)
            roles.contains(Roles.USER) -> {
                getUser(token)
                handler.handle(ctx)
            }
        }
    }

    fun getUser(token : String) : Author{
        try{
            val userId = tokenJWT.validate(token)
            return medium.system.getAuthor(userId)
        }
        catch (e : TokenNotFoundException){
            throw UnauthorizedResponse("Token no encontrado")
        }
        catch (e : UserNotFoundException){
            throw UnauthorizedResponse("Token invalido")
        }
    }

}