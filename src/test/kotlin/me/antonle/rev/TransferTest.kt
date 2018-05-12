package me.antonle.rev

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.get
import kotlinx.coroutines.experimental.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TransferTest {

    val client = HttpClient(Apache)
    val server = Server()

    @BeforeEach
    internal fun setUp() {
        server.start()
    }

    @AfterEach
    internal fun tearDown() {
        server.stop()
    }

    @Test
    fun shouldTestDefaultEndpoint() {
        val response = runBlocking { client.get<String>(url = "http://localhost:8080") }
        assertEquals("Hello World!", response)
    }

    @Test
    fun shouldTestDemoEndpoint() {
        val response = runBlocking { client.get<String>(url = "http://localhost:8080/demo") }
        assertEquals("HELLO WORLD!", response)
    }
}