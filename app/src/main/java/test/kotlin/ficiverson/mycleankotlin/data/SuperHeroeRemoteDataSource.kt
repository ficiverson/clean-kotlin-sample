package test.kotlin.ficiverson.mycleankotlin.data

import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe
import test.kotlin.ficiverson.mycleankotlin.network.HeroeAPI
import test.kotlin.ficiverson.mycleankotlin.network.NetWorkApi

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
class SuperHeroeRemoteDataSource {
    private val url: String = "https://api.myjson.com/"

    @Throws(Exception::class)
    fun getHereoes(): List<SuperHeroe>? {
        val heroeApi = NetWorkApi(url).provideApi(clazz = HeroeAPI::class.java)
        val response = heroeApi.getHeroes().execute()
        if (!response.isSuccessful) {
            throw Exception()
        }
        return response.body()?.superheroes
    }
}