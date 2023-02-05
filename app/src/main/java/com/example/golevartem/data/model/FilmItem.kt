package com.example.golevartem.data.model


import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class FilmItem(
    val nameRu: String?,
    val kinopoiskId: Int,
    val posterUrl: String?,
    val posterUrlPreview: String?,
    val year: Int,
    val description: String?,
    val shortDescription: String?,
    val genres: ArrayList<Genre>?,
    val countries: ArrayList<Country>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Genre),
        parcel.createTypedArrayList(Country)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nameRu)
        parcel.writeInt(kinopoiskId)
        parcel.writeString(posterUrl)
        parcel.writeString(posterUrlPreview)
        parcel.writeInt(year)
        parcel.writeString(description)
        parcel.writeString(shortDescription)
        parcel.writeTypedList(genres)
        parcel.writeTypedList(countries)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FilmItem> {
        override fun createFromParcel(parcel: Parcel): FilmItem {
            return FilmItem(parcel)
        }

        override fun newArray(size: Int): Array<FilmItem?> {
            return arrayOfNulls(size)
        }
    }
}

