package id.furqoncreatice.resepmama

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
    val title: String,
    val image: String,
    val content: String,
    val source: String
) : Parcelable