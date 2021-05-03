package io.github.haniyehkhaksar.weatherapp.utils

import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
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
                        .placeholder(
                            ColorDrawable(
                                ContextCompat.getColor(
                                    imgView.context,
                                    R.color.image_background
                                )
                            )
                        )
                        .error(
                            ColorDrawable(
                                ContextCompat.getColor(
                                    imgView.context,
                                    R.color.image_background
                                )
                            )
                        )
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