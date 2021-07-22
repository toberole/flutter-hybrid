package com.zw.android_flutter;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    public int age;
    public float score;

    public Student() {

    }

    public void readFromParcel(Parcel in) {
        this.age = in.readInt();
        this.score = in.readFloat();
    }

    protected Student(Parcel in) {
        age = in.readInt();
        score = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeFloat(score);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", score=" + score +
                '}';
    }
}