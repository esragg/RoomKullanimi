package com.pisiitech.roomkullanimi

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun tumKisiler():List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisiler: Kisiler)

    @Update
    suspend fun kisiGuncelle(kisiler: Kisiler)

    @Delete
    suspend fun kisiSil(kisiler: Kisiler)

    @Query("SELECT * FROM kisiler ORDER BY RANDOM() LIMIT 1")
    suspend fun rastgele1KisiGetir():List<Kisiler>

}