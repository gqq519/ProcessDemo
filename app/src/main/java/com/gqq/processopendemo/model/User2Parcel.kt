package com.gqq.processopendemo.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by gqq on 2018/4/19.
 */
class User2Parcel() : Parcelable {

    var userId = 0
    var userName = ""
    var isMale = false
    var user = User()

    constructor(parcel: Parcel) : this() {
        userId = parcel.readInt()
        userName = parcel.readString()
        isMale = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(userId)
        parcel.writeString(userName)
        parcel.writeByte(if (isMale) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User2Parcel> {
        override fun createFromParcel(parcel: Parcel): User2Parcel {
            return User2Parcel(parcel)
        }

        override fun newArray(size: Int): Array<User2Parcel?> {
            return arrayOfNulls(size)
        }
    }

}