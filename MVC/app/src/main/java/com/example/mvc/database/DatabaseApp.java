package com.example.mvc.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvc.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class DatabaseApp extends RoomDatabase {
    private static DatabaseApp instance;

    public abstract ProductDao productDao();

    public static synchronized DatabaseApp getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseApp.class, "productsdb")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}