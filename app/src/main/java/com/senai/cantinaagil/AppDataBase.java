package com.senai.cantinaagil;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class AppDataBase extends RoomDatabase {

    public abstract  ProdutoDao produtoDao();

    private static AppDataBase INSTANCE;

    public static synchronized AppDataBase getDataBase(Context context){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDataBase.class,
                    "banco_cantina"
            ).allowMainThreadQueries().build();
        }

        return INSTANCE;

    }

}
