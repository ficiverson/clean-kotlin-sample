package test.kotlin.ficiverson.mycleankotlin.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import test.kotlin.ficiverson.mycleankotlin.R
import test.kotlin.ficiverson.mycleankotlin.model.SuperHeroe


interface MainView {
    fun onHeroeLoaded(heroes: List<SuperHeroe>)
    fun onHeroeError()
}

class MainActivity : AppCompatActivity(), MainView {
    private var mainPresenter: MainPresenter? = null
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: HeroesAdapter
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private lateinit var mEmptyText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById(R.id.rv_heroes_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mEmptyText = findViewById(R.id.tv_empty_list);

        mainPresenter = MainPresenter(view = this)

        mAdapter = HeroesAdapter(presenter = mainPresenter);
        mRecyclerView.setAdapter(mAdapter);
    }

    override fun onHeroeError() {
        mRecyclerView.setVisibility(View.GONE);
        mEmptyText.setVisibility(View.VISIBLE);
        mEmptyText.setText("Not a super heroe this time");
    }

    override fun onHeroeLoaded(heroes: List<SuperHeroe>) {
        //show data
        mAdapter.addAll(heroes);
        mAdapter.notifyDataSetChanged();
    }

}
