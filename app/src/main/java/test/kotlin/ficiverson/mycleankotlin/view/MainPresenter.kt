package test.kotlin.ficiverson.mycleankotlin.view

import test.kotlin.ficiverson.mycleankotlin.executor.SuperHeroUseCase

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
class MainPresenter(view: MainView) {
    private var superoHeroe: SuperHeroUseCase? = null


    init {
        superoHeroe = SuperHeroUseCase()
        superoHeroe?.execute() { (data, error) ->
            data?.let {
                data.success?.let {
                    if (data.success?.size > 0) {
                        view.onHeroeLoaded(data.success)
                    } else {
                        view.onHeroeErro()
                    }
                }
            }
        }
    }

}