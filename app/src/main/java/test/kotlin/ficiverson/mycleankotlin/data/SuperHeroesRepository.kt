package test.kotlin.ficiverson.mycleankotlin.data

import test.kotlin.ficiverson.mycleankotlin.executor.DataPolicy
import test.kotlin.ficiverson.mycleankotlin.executor.Result
import test.kotlin.ficiverson.mycleankotlin.executor.Status
import test.kotlin.ficiverson.mycleankotlin.model.SuperHereoeResponse

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
class SuperHeroesRepository(private val dataSource: SuperHeroeRemoteDataSource) {

    fun getHereoes(policy: DataPolicy): Result<SuperHereoeResponse> {
        return try {
            when (policy) {
                DataPolicy.LOCAL -> Result(error = Exception())
                DataPolicy.NETWORK -> Result(SuperHereoeResponse(Status.SUCCESS, dataSource.getHereoes()))
                DataPolicy.NETWORK_AND_LOCAL -> Result(SuperHereoeResponse(Status.SUCCESS, dataSource.getHereoes()))
            }
        } catch (e: Exception) {
            Result(error = Exception())
        }
    }
}