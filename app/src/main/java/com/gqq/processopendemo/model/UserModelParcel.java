package com.gqq.processopendemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gqq on 2018/4/19.
 */

public class UserModelParcel implements Parcelable{

    private int userId;
    private String userName;
    private boolean isMale;
    private UserParcel userParcel;

    protected UserModelParcel(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
        userParcel = in.readParcelable(UserParcel.class.getClassLoader());
    }

    public UserModelParcel(int userId, String userName, boolean isMale, UserParcel userParcel) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
        this.userParcel = userParcel;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeByte((byte) (isMale ? 1 : 0));
        dest.writeParcelable(userParcel, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserModelParcel> CREATOR = new Creator<UserModelParcel>() {
        @Override
        public UserModelParcel createFromParcel(Parcel in) {
            return new UserModelParcel(in);
        }

        @Override
        public UserModelParcel[] newArray(int size) {
            return new UserModelParcel[size];
        }
    };

    @Override
    public String toString() {
        return "UserModelParcel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", isMale=" + isMale +
                ", userParcel=" + userParcel +
                '}';
    }
}
