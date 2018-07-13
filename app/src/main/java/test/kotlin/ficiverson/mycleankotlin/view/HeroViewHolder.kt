package test.kotlin.ficiverson.mycleankotlin.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.marvel_hero_row.view.*
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe

/**
 * Created by f.souto.gonzalez on 23/05/2018.
 */
class HeroViewHolder(item: View, private val presenter: MainPresenter?) : RecyclerView.ViewHolder(item) {

    fun render(marvelHero: SuperHeroe) {
        hookListeners(marvelHero)
        Picasso.with(itemView.context)
            .load(marvelHero.photo)
            .into(itemView.imHeroImage)
        itemView.tvHeroName.text = marvelHero.name
    }

    private fun hookListeners(marvelHero: SuperHeroe) {
        itemView.setOnClickListener {
            presenter?.onMarvelHeroClick(itemView.context, marvelHero)
        }
    }
}
