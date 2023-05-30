package com.itmindco

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.html.Span
import io.kvision.module
import io.kvision.panel.root
import io.kvision.startApplication

//val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application() {

    override fun start(state: Map<String, Any>) {
        val root = root("kvapp") {
        }
        root.add(Span("hello"))
//        AppScope.launch {
//            val pingResult = Model.ping("Hello world from client!")
//            root.add(Span(pingResult))
//        }
    }
}

fun main() {
    startApplication(
        ::App,
        module.hot,
//        BootstrapModule,
//        BootstrapCssModule,
//        DatetimeModule,
//        BootstrapIconsModule,
//        TabulatorModule,
//        TabulatorCssBootstrapModule,
        CoreModule
    )
}
