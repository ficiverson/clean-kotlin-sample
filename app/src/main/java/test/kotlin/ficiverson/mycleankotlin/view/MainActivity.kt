package test.kotlin.ficiverson.mycleankotlin.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_state.*
import test.kotlin.ficiverson.mycleankotlin.R
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe
import test.kotlin.ficiverson.mycleankotlin.utils.gone
import test.kotlin.ficiverson.mycleankotlin.utils.visible


interface MainView {
    fun onHeroeLoaded(heroes: List<SuperHeroe>)
    fun onHeroeError()
}

class MainActivity : AppCompatActivity(), MainView {
    private val mainPresenter: MainPresenter = MainPresenter(this)
    private lateinit var adapter: HeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = HeroesAdapter(mainPresenter)
        rvHeroesList.apply {
            setHasFixedSize(true)
            adapter = this@MainActivity.adapter.apply {
                setHasStableIds(true)
            }
        }
    }

    override fun onHeroeError() {
        rvHeroesList.visible()
        tvEmptyList.gone()
        tvEmptyList.text = "Not a super heroe this time"
    }

    override fun onHeroeLoaded(heroes: List<SuperHeroe>) {
        //show data
        adapter.superHeroes = heroes.toMutableList()
    }

}
