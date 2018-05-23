package test.kotlin.ficiverson.mycleankotlin.model

import com.google.gson.annotations.SerializedName
import test.kotlin.ficiverson.mycleankotlin.executor.Status

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
data class SuperHeroeList(
        @SerializedName("superheroes") val superheroes: List<SuperHeroe>
)

data class SuperHeroe(
        @SerializedName("name") val name: String,
        @SerializedName("photo") val photo: String,
        @SerializedName("realName") val realName: String,
        @SerializedName("height") val height: String,
        @SerializedName("power") val power: String
)


data class SuperHereoeResponse(val status: Status, val success: List<SuperHeroe>?, val error: Exception?) {
    constructor(status: Status, success: List<SuperHeroe>?) : this(status, success, null)
    constructor(status: Status, error: Exception?) : this(status, null, error)
}