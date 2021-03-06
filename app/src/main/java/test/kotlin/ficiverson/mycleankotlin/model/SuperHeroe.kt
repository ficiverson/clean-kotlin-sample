package test.kotlin.ficiverson.mycleankotlin.model

import test.kotlin.ficiverson.mycleankotlin.executor.Status

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
data class SuperHeroeList(
    val superheroes: List<SuperHeroe>
)

data class SuperHeroe(
    val name: String,
    val photo: String,
    val realName: String,
    val height: String,
    val power: String
)


data class SuperHereoeResponse(val status: Status, val success: List<SuperHeroe>?, val error: Exception?) {
    constructor(status: Status, success: List<SuperHeroe>?) : this(status, success, null)
    constructor(status: Status, error: Exception?) : this(status, null, error)
}