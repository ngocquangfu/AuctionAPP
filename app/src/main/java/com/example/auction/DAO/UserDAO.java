package com.example.auction.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.auction.model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);

    @Insert
    void register(User user);


    @Query("Select * from user")
    List<User> getListUser();


    @Query("SELECT * FROM user WHERE email = :email")
    boolean Check_Email(String email);

}


