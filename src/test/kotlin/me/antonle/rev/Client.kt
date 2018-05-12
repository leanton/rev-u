package me.antonle.rev

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.get
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {

    runBlocking {
        val client = HttpClient(Apache)
        val htmlContent = client.get<String>("https://en.wikipedia.org/wiki/Main_Page")
        println(htmlContent)
    }

}