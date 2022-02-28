package com.example.auction.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.auction.model.Category;
import com.example.auction.model.User;

import java.util.List;

@Dao
public interface CategoryDAO {
    @Insert
    void insertCategory(Category category);


    @Query("Select * from category")
    List<User> getListCategory();
}
