package com.kamikaze.firstkotlinprogram.databaseroomdb
//
//import androidx.room.*
//import kotlinx.coroutines.flow.Flow
//@Dao
//interface NotesDAO {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(notes: Notes)
//
//    @Delete
//    suspend fun delete(notes: Notes)
//
//    @Query("Select * from notes_table ORDER BY word ASC")
//     fun getAllNotes():Flow<List<Notes>>
//
//    @Query("DELETE FROM notes_table")
//    suspend fun deleteAll()
//
//    @Update
//    suspend fun update( notes: Notes)
//}
