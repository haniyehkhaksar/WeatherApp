package io.github.haniyehkhaksar.weatherapp.utils

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.github.haniyehkhaksar.weatherapp.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imgView: ImageView, imgUrl: String?) {

        imgUrl?.let {
            val imgUri = it.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_baseline_search_24)
                        .error(R.drawable.ic_baseline_search_24)
                )
                .into(imgView)
        }
    }

    @JvmStatic
    @BindingAdapter("hasFixedSize")
    fun setHasFixedSize(view: RecyclerView, hasFixedSize: Boolean) {
        view.setHasFixedSize(hasFixedSize)
    }

}