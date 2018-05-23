package test.kotlin.ficiverson.mycleankotlin.view

import android.content.Context
import android.widget.Toast
import test.kotlin.ficiverson.mycleankotlin.executor.SuperHeroUseCase
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe

/**
 * Created by f.souto.gonzalez on 22/05/2018.
 */
class MainPresenter(private val view: MainView) {
    private var superoHeroe: SuperHeroUseCase? = null


    init {
        superoHeroe = SuperHeroUseCase()
        superoHeroe?.execute() { (data, error) ->
            data?.let {
                data.success?.let {
                    if (data.success?.size > 0) {
                        view.onHeroeLoaded(data.success)
                    } else {
                        view.onHeroeError()
                    }
                }
            }
        }
    }

    fun onMarvelHeroClick(context: Context, marvelHero: SuperHeroe) {
        Toast.makeText(context, "The power is: " + marvelHero.power, Toast.LENGTH_SHORT).show();
    }

}