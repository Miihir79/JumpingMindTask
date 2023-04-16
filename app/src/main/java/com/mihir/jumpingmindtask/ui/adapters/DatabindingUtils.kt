package com.mihir.jumpingmindtask.ui.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

@BindingAdapter("loadImg")
fun ImageView.loadImg(url:String){

    val shimmer = Shimmer.AlphaHighlightBuilder()
        .setDuration(1800)
        .setBaseAlpha(0.7f)
        .setHighlightAlpha(0.6f)
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .setAutoStart(true)
        .build()

    val shimmerDrawable = ShimmerDrawable().apply {
        setShimmer(shimmer)
    }
    this.load(url) {
        placeholder(shimmerDrawable)
    }

}

@BindingAdapter("setFirstDateText")
fun TextView.setFirstDateText(date:String){
    this.text = "First Brewed on: $date"
}

@BindingAdapter("setTagLine")
fun TextView.setTagLine(tagLine:String){
    this.text = "\" $tagLine \" "
}