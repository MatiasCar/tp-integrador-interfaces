package org.example

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.core.security.Role
import io.javalin.core.util.RouteOverviewPlugin
import org.example.model.Medium

enum class Roles : Role {
    ANYONE, USER
}

fun main(args: Array<String>) {

    val medium = Medium()
    val jwtToken = MediumTokenJWT()
    val jwtAccessManager = MediumAccessManager(jwtToken, medium)

    medium.register("jorge", "jorge@gmail.com","1234","foto.jpg")

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

        }
        path("login"){

        }
        path("user"){

        }
        path("content"){

        }
        path("search"){

        }
        path("category"){

        }
    }
}
