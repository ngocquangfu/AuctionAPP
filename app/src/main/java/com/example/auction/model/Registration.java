package com.example.auction.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "registration")
public class Registration {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "item_id")
    private int item_id;
    @ColumnInfo(name = "user_id")
    private int user_id;
    @ColumnInfo(name = "date_start")
    private String date_start;

    @Ignore
    public Registration() {
    }

    public Registration(int item_id, int user_id, String date_start) {
        this.item_id = item_id;
        this.user_id = user_id;
        this.date_start = date_start;
    }

    public Registration(int id, int item_id, int user_id, String date_start) {
        this.id = id;
        this.item_id = item_id;
        this.user_id = user_id;
        this.date_start = date_start;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }
}
