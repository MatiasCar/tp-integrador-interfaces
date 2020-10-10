package org.example

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.core.security.Role
import io.javalin.core.util.RouteOverviewPlugin

enum class Roles : Role {
    ANYONE, USER
}

fun main(args: Array<String>) {
    val app = Javalin.create{
        it.defaultContentType = "applicatoin/json"
        it.registerPlugin(RouteOverviewPlugin("/routes"))
    }

    app.before {
        it.header("Access-Control-Expose-Headers","*")
    }

    app.start(7000)

    app.routes {
        path("register"){
            //post
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
