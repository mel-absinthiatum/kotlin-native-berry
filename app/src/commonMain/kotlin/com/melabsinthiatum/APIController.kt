package com.melabsinthiatum

import com.melabsinthiatum.shared.ApplicationDispatcher
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.coroutines.*

class APIController {
    private val httpClient = HttpClient()

    var sampleUrl = Url("https://tools.ietf.org/rfc/rfc1866.txt")

    fun sampleGet(callback: (String) -> Unit) {
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val result: String = httpClient.get {
                    url(this@APIController.sampleUrl.toString())
                }

                callback(result)
            }
        }
    }

    fun sampleGetWithSerializing(success: (String) -> Unit, failure: (Throwable?) -> Unit){
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val url = "https://pokeapi.co/api/v2/pokedex/kanto/"
                val json = httpClient.get<String>(url)
                success(json)
//                Json.nonstrict.parse(Pokedex.serializer(), json)
//                    .pokemon_entries
//                    .also(success)
            } catch (ex: Exception){
                failure(ex)
            }
        }
    }

}