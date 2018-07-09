package test.kotlin.ficiverson.mycleankotlin.view

import android.content.Context
import test.kotlin.ficiverson.mycleankotlin.executor.SuperHeroUseCase
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe
import test.kotlin.ficiverson.mycleankotlin.utils.showMessage

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
class MainPresenter(private val view: MainView) {

    init {
        fetchSuperHeroes(SuperHeroUseCase())
    }

    private fun fetchSuperHeroes(superHeroeUseCase: SuperHeroUseCase) {
        superHeroeUseCase.execute {
            it.data?.success?.let {
                if (it.isNotEmpty()) {
                    view.onHeroeLoaded(it)
                } else {
                    view.onHeroeError()
                }
            } ?: view.onHeroeError()
        }
    }

    fun onMarvelHeroClick(context: Context, marvelHero: SuperHeroe) {
        context.showMessage("The power is: ${marvelHero.power}")
    }

}