package org.example

import io.javalin.core.security.AccessManager
import io.javalin.core.security.Role
import io.javalin.http.Context
import io.javalin.http.Handler
import io.javalin.http.UnauthorizedResponse

import org.ui.Author
import org.ui.MediumSystem
import org.ui.NotFound

class MediumAccessManager(val tokenJWT: MediumTokenJWT, val medium: MediumSystem): AccessManager{
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
            return medium.getAuthor(userId)
        }
        catch (e : NotFound){
            throw UnauthorizedResponse("Token not found")
        }
        catch (e : NotFound){
            throw UnauthorizedResponse("Invalid token")
        }
    }

}