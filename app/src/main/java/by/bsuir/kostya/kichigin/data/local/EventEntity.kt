package by.bsuir.kostya.kichigin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = EventEntity.TableName)
data class EventEntity(
    @PrimaryKey
    val eventId: UUID,
    val name: String? = null,
    val date: String? = null,
    val type: String? = null,
    val description: String? = null,
    val notes: String? = null
){
    internal companion object {
        const val TableName = "EventEntity"
    }
}