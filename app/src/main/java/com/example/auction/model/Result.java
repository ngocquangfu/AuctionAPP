package com.example.auction.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "result")
public class Result {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "item_id")
    private int item_id;
    @ColumnInfo(name = "user_id")
    private int user_id;
    @ColumnInfo(name = "max_money")
    private int max_money;

    @Ignore
    public Result() {
    }

    public Result(int item_id, int user_id, int max_money) {
        this.item_id = item_id;
        this.user_id = user_id;
        this.max_money = max_money;
    }

    public Result(int id, int item_id, int user_id, int max_money) {
        this.id = id;
        this.item_id = item_id;
        this.user_id = user_id;
        this.max_money = max_money;
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

    public int getMax_money() {
        return max_money;
    }

    public void setMax_money(int max_money) {
        this.max_money = max_money;
    }
}
