package com.example.auction.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "transaction")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "item_id")
    private int item_id;
    @ColumnInfo(name = "user_id")
    private int user_id;
    private int host;
    private int participants;
    private int price;

    @Ignore
    public Transaction() {
    }

    public Transaction(int user_id, int host, int participants, int item_id, int price) {
        this.user_id = user_id;
        this.host = host;
        this.participants = participants;
        this.item_id = item_id;
        this.price = price;
    }

    public Transaction(int id, int user_id, int host, int participants, int item_id, int price) {
        this.id = id;
        this.user_id = user_id;
        this.host = host;
        this.participants = participants;
        this.item_id = item_id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getHost() {
        return host;
    }

    public void setHost(int host) {
        this.host = host;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
