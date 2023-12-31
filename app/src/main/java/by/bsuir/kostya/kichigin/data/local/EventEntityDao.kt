package by.bsuir.kostya.kichigin.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface EventEntityDao {
    @Query("SELECT * FROM ${EventEntity.TableName}")
    fun getEventsEntities(): Flow<List<EventEntity>>

    @Query("SELECT * FROM ${EventEntity.TableName} WHERE eventId = :eventId")
    fun getEventEntity(eventId: UUID): Flow<EventEntity?>

    @Upsert
    suspend fun upsertEventEntity(event: EventEntity)

    @Query("DELETE FROM ${EventEntity.TableName} WHERE eventId = :eventId")
    suspend fun deleteEventEntity(eventId: UUID)
}