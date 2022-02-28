package com.example.auction.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart")
public class Cart {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "item_id")
    private int user_id;
    @ColumnInfo(name = "item_id")
    private int item_id;
    @ColumnInfo(name = "price")
    private int price;
    @ColumnInfo(name = "quantity")
    private int quantity;

    public Cart(int id, int user_id, int item_id, int price, int quantity) {
        this.id = id;
        this.user_id = user_id;
        this.item_id = item_id;
        this.price = price;
        this.quantity = quantity;
    }

    @Ignore
    public Cart() {
    }

    public Cart(int user_id, int item_id, int price, int quantity) {
        this.user_id = user_id;
        this.item_id = item_id;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
