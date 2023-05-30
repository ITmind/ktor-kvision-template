package com.itmindco

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.itmindco.plugins.*
import io.ktor.server.routing.*
import io.kvision.remote.applyRoutes
import io.kvision.remote.getServiceManager
import io.kvision.remote.kvisionInit
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf


fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val module = module {
        factoryOf(::PingService)
    }

    configureSecurity()
    configureMonitoring()
    //configureSerialization()
    configureDatabases()
    configureRouting()

    routing {
        applyRoutes(getServiceManager<IPingService>())
    }

    kvisionInit(module)
}
