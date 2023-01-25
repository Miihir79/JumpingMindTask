package com.mihir.jumpingmindtask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mihir.jumpingmindtask.model.BeerDataItem

@Database(entities = [BeerDataItem::class],version = 1,exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class FavDatabase: RoomDatabase() {

    abstract fun favDao(): FavInterface

    companion object{
        @Volatile
        private var INSTANCE: FavDatabase?=null

        fun getDatabase(context: Context): FavDatabase {
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavDatabase::class.java,
                    "fav_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}