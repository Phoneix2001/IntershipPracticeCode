package com.kamikaze.firstkotlinprogram.databaseroomdb

//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//@Database(entities = [Notes::class], version = 1, exportSchema = false)
//public abstract class NotesRoomDatabase : RoomDatabase() {
//    abstract fun notesDao(): NotesDAO
//
//    companion object {
//        @Volatile
//        private var INSTANCE: NotesRoomDatabase? = null
//
//        fun getDatabase(context: Context): NotesRoomDatabase {
//
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    NotesRoomDatabase::class.java,
//                    "notes_table"
//                ).build()
//                INSTANCE = instance
//
//                instance
//            }
//        }
//    }
//}