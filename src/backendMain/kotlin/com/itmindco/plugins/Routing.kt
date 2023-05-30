package com.itmindco.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/") {
            call.respondFile(File("static/index.html"))
            //call.respondText("Hello World!")
//            call.respondHtml {
//                body {
//                    div {
//                        id = "js-response"
//                        +"Loading..."
//                    }
//                    script(src = "/static/require.min.js") {
//                    }
//                }
//            }
        }

        staticFiles("/static", File("static"))
    }
}
