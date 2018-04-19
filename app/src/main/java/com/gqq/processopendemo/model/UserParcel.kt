package com.gqq.processopendemo.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by gqq on 2018/4/19.
 */
class UserParcel(private var userId: Int, private var userName: String, private var isMale: Boolean) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(userId)
        parcel.writeString(userName)
        parcel.writeByte(if (isMale) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "UserParcel(userId=$userId, userName='$userName', isMale=$isMale)"
    }

    companion object CREATOR : Parcelable.Creator<UserParcel> {
        override fun createFromParcel(parcel: Parcel): UserParcel {
            return UserParcel(parcel)
        }

        override fun newArray(size: Int): Array<UserParcel?> {
            return arrayOfNulls(size)
        }
    }



}