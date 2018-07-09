package test.kotlin.ficiverson.mycleankotlin.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import test.kotlin.ficiverson.mycleankotlin.R
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe

/**
 * Created by fernando souto on 30/01/2018.
 */

class HeroesAdapter(private var presenter: MainPresenter?) : RecyclerView.Adapter<HeroViewHolder>() {

    var superHeroes = mutableListOf<SuperHeroe>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder =
        HeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.marvel_hero_row, parent, false),
            presenter
        )

    override fun getItemId(position: Int): Long = superHeroes[position].hashCode().toLong()

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.render(superHeroes[position])
    }

    override fun getItemCount(): Int = superHeroes.size

}