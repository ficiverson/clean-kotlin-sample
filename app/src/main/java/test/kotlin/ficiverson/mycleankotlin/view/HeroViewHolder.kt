package test.kotlin.ficiverson.mycleankotlin.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import test.kotlin.ficiverson.mycleankotlin.R
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe

/**
 * Created by f.souto.gonzalez on 23/05/2018.
 */
class HeroViewHolder(itemView: View, private val presenter: MainPresenter?) : RecyclerView.ViewHolder(itemView) {
    private val heroImage: ImageView = itemView.findViewById(R.id.im_hero_image)
    private val heroName: TextView = itemView.findViewById(R.id.tv_hero_name)
    private val context: Context = itemView.getContext()

    fun render(marvelHero: SuperHeroe) {
        hookListeners(marvelHero)
        Picasso.with(context).load(marvelHero.photo).into(heroImage)
        heroName.text = marvelHero.name
    }

    private fun hookListeners(marvelHero: SuperHeroe) {
        itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                presenter?.onMarvelHeroClick(context, marvelHero)
            }
        })
    }
}
