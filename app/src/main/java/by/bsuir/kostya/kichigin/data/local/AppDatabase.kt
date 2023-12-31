package by.bsuir.kostya.kichigin.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [EventEntity::class], version = 1, exportSchema=true)
@TypeConverters(UUIDConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventEntityDao
}

internal fun AppDatabase(context: Context) = Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "event_database"
)
    .fallbackToDestructiveMigration()
    .build()