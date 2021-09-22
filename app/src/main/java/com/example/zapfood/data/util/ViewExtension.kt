package com.example.zapfood.data.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar


/*fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .centerCrop()
        .into(this)
    }*/

fun View.viewVisible(){
    this.visibility = View.VISIBLE
}

fun View.viewInvisible(){
    this.visibility = View.INVISIBLE
}

fun View.viewGone(){
    this.visibility = View.GONE
}

// Snackbar Extensions
fun View.showSnackbarRed(message : String){
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snackBar.setBackgroundTint(Color.RED)
    snackBar.show()
}

fun View.showSnackbar(message : String){
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
    snackBar.show()
}

fun View.snackBarWithAction(message : String, actionLabel : String,
                            block : () -> Unit){
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
            .setAction(actionLabel) {
                block()
            }
}

fun Context.copyToClipboard(text: CharSequence){
    val clipboard = getSystemService(ClipboardManager::class.java)
    val clip = ClipData.newPlainText("label",text)
    clipboard.setPrimaryClip(clip)
}

