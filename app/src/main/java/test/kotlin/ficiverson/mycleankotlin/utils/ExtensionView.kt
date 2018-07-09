package test.kotlin.ficiverson.mycleankotlin.utils

import android.content.Context
import android.view.View
import android.widget.Toast

/**
 * Created by f.souto.gonzalez on 23/05/2018.
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Context.showMessage(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}