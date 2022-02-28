package com.example.auction.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.auction.DAO.CategoryDAO;
import com.example.auction.DAO.UserDAO;
import com.example.auction.model.User;


@Database(entities = (User.class), version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static final String DB_NAME = "Auction_APP.sqlite";
    private static UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DB_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract UserDAO userDAO();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
