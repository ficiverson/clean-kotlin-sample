package test.kotlin.ficiverson.mycleankotlin.network

import retrofit2.Call
import retrofit2.http.GET
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroeList

/**
 * Created by f.souto.gonzalez on 23/05/2018.
 */
interface HeroeAPI {
    @GET("bins/bvyob")
    fun getHeroes(): Call<SuperHeroeList>
}