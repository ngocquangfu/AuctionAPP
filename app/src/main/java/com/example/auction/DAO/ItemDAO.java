package com.example.auction.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.auction.model.Item;

import java.util.List;

@Dao
public  interface ItemDAO {
    @Insert
    void insertItem(Item product);


    @Query("Select * from item")
    List<Item> getListItem();
}
