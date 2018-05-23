package test.kotlin.ficiverson.mycleankotlin.data

import retrofit2.Response
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroeList
import test.kotlin.ficiverson.mycleankotlin.network.HeroeAPI
import test.kotlin.ficiverson.mycleankotlin.network.NetWorkApi

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
class SuperHeroeRemoteDataSource {
    private val url: String = "https://api.myjson.com/"

    fun getHereoes(): List<SuperHeroe>? {
        val header: Map<String, String> = HashMap<String, String>()
        val heroeApi: HeroeAPI = NetWorkApi(url).provideApi(headers = header, clazz = HeroeAPI::class.java)

        val response: Response<SuperHeroeList> = heroeApi.getHeroes().execute()
        if (!response.isSuccessful) {
            throw Exception()
        }
        return response.body()?.superheroes
    }
}