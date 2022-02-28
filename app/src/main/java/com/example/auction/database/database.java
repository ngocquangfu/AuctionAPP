package com.example.auction.database;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.auction.model.Item;
import com.example.auction.model.Category;
import com.example.auction.model.Wallet;
import com.example.auction.model.User;

import android.database.DatabaseErrorHandler;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import java.util.ArrayList;

//@androidx.room.Database(entities = {User.class, Product.class}, version = 1)
class Database extends SQLiteOpenHelper {
    public static final String DBNAME = "Auction.sqlite";
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PHONE = "phone";
    public static final String TABLE_Category = "category";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_PRICE = "price";

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, DBNAME, factory, 2, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        String sqlCreateTableProduct =
                "CREATE TABLE " + TABLE_Category + "(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT," +
                        COLUMN_DESCRIPTION + " TEXT," +
                        COLUMN_IMAGE + " INTEGER );";
        System.out.println(sqlCreateTableProduct);
        String sqlCreateTableWord =
                "CREATE TABLE " + TABLE_USERS + "(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_EMAIL + " TEXT," +
                        COLUMN_PASSWORD + " TEXT," +
                        COLUMN_USERNAME + " TEXT," +
                        COLUMN_PHONE + " TEXT" + ")";

        MyDB.execSQL(sqlCreateTableProduct);
        MyDB.execSQL(sqlCreateTableWord);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Category);
        onCreate(db);
    }

    public long insertDB(User user) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", user.getEmail());
        contentValues.put("password", user.getPassword());
        contentValues.put("phone", user.getPhone());
        contentValues.put("username", user.getUsername());
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_USERS, null, contentValues);
        db.close();
        return result;

    }


    public ArrayList<User> selectAll() {
        ArrayList<User> ret = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Select * from " + TABLE_USERS;
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                User dic = new User();
                dic.setId(Integer.parseInt(cursor.getString(0)));
                dic.setEmail(cursor.getString(1));
                dic.setPassword(cursor.getString(2));
                dic.setUsername(cursor.getString(3));
                dic.setPhone(cursor.getString(4));
                ret.add(dic);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
            cursor.close();
            db.close();
        }

        return ret;
    }

    public Boolean Login(String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email =? and password= ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public long insert(User user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD, user.getPassword());
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_USERS, null, values);
        db.close();
        return result;
    }

    public User checkEmail(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email =?", new String[]{user.getEmail()});
        if (cursor != null && cursor.moveToFirst()) {

            User dic = new User();
            dic.setId(Integer.parseInt(cursor.getString(0)));
            dic.setEmail(cursor.getString(1));
            dic.setPassword(cursor.getString(2));
//                dic.setUsername(cursor.getString(3));
//                dic.setPhone(cursor.getString(4));
            cursor.close();
            db.close();
            return dic;
        }
        return null;
    }


//    public ArrayList<Category> selectAllCategory() {
//        ArrayList<Category> ret = new ArrayList();
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sql = "Select * from  category";
//        Cursor cursor = db.rawQuery(sql, null);
//
//        if (cursor != null && cursor.moveToFirst()) {
//            do {
//                Category dic = new Category();
//                dic.setId(Integer.parseInt(cursor.getString(0)));
//                dic.setName(cursor.getString(1));
//                dic.setDescription(cursor.getString(2));
//
//                ret.add(dic);
//                cursor.moveToNext();
//            } while (!cursor.isAfterLast());
//            cursor.close();
//            db.close();
//        }
//
//        return ret;
//    }


//    public long insertProduct(Product product) {
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAME, product.getName());
//        values.put(COLUMN_DESCRIPTION, product.getDescription());
//        values.put(COLUMN_PRICE, product.getPrice());
//        System.out.println(product.getDescription());
//        SQLiteDatabase db = this.getWritableDatabase();
//        long result = db.insert(TABLE_PRODUCT, null, values);
//        System.out.println(result + "huyddđ");
//        System.out.println();
//        db.close();
//        return result;
//    }

}
