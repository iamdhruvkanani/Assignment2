package sheridan.kananid.assignment2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "gamescores")
data class Envelope(
    @PrimaryKey(autoGenerate = true)
    var id : Long,

    @ColumnInfo(name = "die_one")
    val dieOne : String,
    @ColumnInfo(name = "die_two")
    val dieTwo : String,
    @ColumnInfo(name = "die_three")
    val dieThree : String,
    @ColumnInfo(name = "die_total")
    val dieTotal : String,
    @ColumnInfo(name = "time_stamp")
    val timeStamp: Date
)