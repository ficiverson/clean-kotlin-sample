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
        try {
            when (policy) {
                DataPolicy.LOCAL -> return Result(data = null, error = Exception())
                DataPolicy.NETWORK -> return Result(data = SuperHereoeResponse(status = Status.SUCCESS, success = dataSource.getHereoes()))
                DataPolicy.NETWORK_AND_LOCAL -> return Result(data = SuperHereoeResponse(status = Status.SUCCESS, success = dataSource.getHereoes()))
            }
        } catch (e: Exception) {
            return Result(data = null, error = Exception())
        }
    }
}