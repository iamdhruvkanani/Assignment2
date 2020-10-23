package sheridan.kananid.assignment2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EnvelopeDao {
    @Insert
    suspend fun insert(envelope: Envelope): Long

    @Query("SELECT * FROM gamescores ORDER BY id")
    fun getAll() : LiveData<List<Envelope>>

    @Delete
    suspend fun delete(envelope: Envelope)

    @Query("DELETE FROM gamescores")
    suspend fun deleteAll()
}