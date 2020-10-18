package org.example

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

import io.javalin.core.security.Role
import io.javalin.core.util.RouteOverviewPlugin
import org.example.controllers.ContentController
import org.example.controllers.UserController
import org.ui.bootstrap.getMediumSystem

enum class Roles : Role {
    ANYONE, USER
}

fun main(args: Array<String>) {

    val medium = getMediumSystem()
    val jwtToken = MediumTokenJWT()
    val jwtAccessManager = MediumAccessManager(jwtToken, medium)
    val contentController = ContentController(jwtToken,medium)
    val userController = UserController(jwtToken, medium)



    val app = Javalin.create{
        it.defaultContentType = "applicatoin/json"
        it.registerPlugin(RouteOverviewPlugin("/routes"))
        it.enableCorsForAllOrigins()
        it.accessManager(jwtAccessManager)
    }

    app.before {
        it.header("Access-Control-Expose-Headers","*")
    }

    app.start(7000)

    app.routes {
        path("register"){
            post(userController::createUser, mutableSetOf<Role>(Roles.ANYONE))
        }
        path("login"){
            post(userController::login, mutableSetOf<Role>(Roles.ANYONE))
        }
        path("user"){
            get(userController::getUser, mutableSetOf<Role>(Roles.USER))
            path("notes"){
                get(userController::getNotes, mutableSetOf<Role>(Roles.USER))
            }
        }
        path("content"){
            get(contentController::getContent, mutableSetOf<Role>(Roles.USER))
            path(":contentId"){
                get(contentController::getNoteById, mutableSetOf<Role>(Roles.USER))
                post(contentController::addCommentToNoteById, mutableSetOf<Role>(Roles.USER))
            }
        }
        path("search"){
            get(contentController::searchNoteByTitle, mutableSetOf<Role>(Roles.USER))
        }
        path("category"){
            path(":name"){
                get(contentController::searchNoteByCategory, mutableSetOf<Role>(Roles.USER))
            }
        }
    }
}
