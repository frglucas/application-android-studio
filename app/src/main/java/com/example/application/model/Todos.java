package com.example.application.model;


import android.os.Parcel;
import android.os.Parcelable;


import java.util.Objects;

public class Todos implements Parcelable {

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todos(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    protected Todos(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        completed = in.readByte() != 0;
    }

    public static final Creator<Todos> CREATOR = new Creator<Todos>() {
        @Override
        public Todos createFromParcel(Parcel in) {
            return new Todos(in);
        }

        @Override
        public Todos[] newArray(int size) {
            return new Todos[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todos todos = (Todos) o;
        return userId == todos.userId && id == todos.id && completed == todos.completed && Objects.equals(title, todos.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, title, completed);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getUserId());
        parcel.writeInt(getId());
        parcel.writeString(getTitle());
        parcel.writeByte((byte) (completed ? 1 : 0));
    }
}
