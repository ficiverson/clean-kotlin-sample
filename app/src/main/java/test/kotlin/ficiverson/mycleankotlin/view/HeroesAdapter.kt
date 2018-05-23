package test.kotlin.ficiverson.mycleankotlin.view

/**
 * Created by f.souto.gonzalez on 23/05/2018.
 */

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import test.kotlin.ficiverson.mycleankotlin.R
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe
import java.util.*

/**
 * Created by fernando souto on 30/01/2018.
 */

class HeroesAdapter(private var presenter: MainPresenter?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val superHeroes: MutableList<SuperHeroe>

    init {
        this.superHeroes = ArrayList<SuperHeroe>()
    }

    fun addAll(heroes: List<SuperHeroe>) {
        superHeroes.addAll(heroes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.marvel_hero_row, parent, false)
        return HeroViewHolder(view, presenter)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val superHeroViewHolder = holder as HeroViewHolder
        val superHero = superHeroes[position]
        superHeroViewHolder.render(superHero)
    }

    override fun getItemCount(): Int {
        return superHeroes.size
    }
}