package com.istinye.week8;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelablePerson implements Parcelable {
    private String name;

    public ParcelablePerson(String name) {
        this.name = name;
    }

    protected ParcelablePerson(Parcel in) {
        name = in.readString();
    }

    public static final Creator<ParcelablePerson> CREATOR = new Creator<ParcelablePerson>() {
        @Override
        public ParcelablePerson createFromParcel(Parcel in) {
            return new ParcelablePerson(in);
        }

        @Override
        public ParcelablePerson[] newArray(int size) {
            return new ParcelablePerson[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
