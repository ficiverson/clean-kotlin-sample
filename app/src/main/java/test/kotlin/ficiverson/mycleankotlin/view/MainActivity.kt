package test.kotlin.ficiverson.mycleankotlin.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import test.kotlin.ficiverson.mycleankotlin.R
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe

interface MainView {
    fun onHeroeLoaded(heroes : List<SuperHeroe> )
    fun onHeroeErro()
}

class MainActivity : AppCompatActivity(), MainView {
    private var mainPresenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainPresenter(view = this)
    }

    override fun onHeroeErro() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onHeroeLoaded(heroes : List<SuperHeroe>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
