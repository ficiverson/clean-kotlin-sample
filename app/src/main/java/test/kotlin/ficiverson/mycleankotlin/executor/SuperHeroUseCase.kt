package test.kotlin.ficiverson.mycleankotlin.executor

import test.kotlin.ficiverson.mycleankotlin.data.SuperHeroeRemoteDataSource
import test.kotlin.ficiverson.mycleankotlin.data.SuperHeroesRepository
import test.kotlin.ficiverson.mycleankotlin.model.SuperHereoeResponse

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
class SuperHeroUseCase(
        private val repository: SuperHeroesRepository = SuperHeroesRepository(SuperHeroeRemoteDataSource()),
        executor: InteractorExecutor = ThreadPoolExecutor
) : BaseInteractor<Unit, Result<SuperHereoeResponse>>(executor) {

    override fun execute(params: Unit?, callback: Callback<Result<SuperHereoeResponse>>) {
        runOnExecutor {
            notifyResult(repository.getHereoes(DataPolicy.NETWORK), callback)
        }
    }
}