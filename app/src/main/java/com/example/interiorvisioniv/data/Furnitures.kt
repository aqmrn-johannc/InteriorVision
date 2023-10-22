package com.example.interiorvisioniv.data

import android.os.Parcel
import android.os.Parcelable

data class Furnitures(var itemId: String,
                      var category: String,
                      var furnitureImage: Int,
                      var furnitureName: String,
                      var furniturePrice: Double,
                      var favStatus: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(itemId)
        parcel.writeString(category)
        parcel.writeInt(furnitureImage)
        parcel.writeString(furnitureName)
        parcel.writeDouble(furniturePrice)
        parcel.writeString(favStatus)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Furnitures> {
        override fun createFromParcel(parcel: Parcel): Furnitures {
            return Furnitures(parcel)
        }

        override fun newArray(size: Int): Array<Furnitures?> {
            return arrayOfNulls(size)
        }
    }
}
