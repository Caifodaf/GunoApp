package ru.android.emotionapp.uitilits

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .into(view)
}

//@BindingMethods(value = [
//    BindingMethod(
//        type = ImageView::class,
//        attribute = "tint",
//        method = "setTint")])