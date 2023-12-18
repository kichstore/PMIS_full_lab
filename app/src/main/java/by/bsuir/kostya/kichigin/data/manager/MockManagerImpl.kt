package by.bsuir.kostya.kichigin.data.manager

import by.bsuir.kostya.kichigin.data.LocalNasaEventDataSource
import by.bsuir.kostya.kichigin.domain.manager.LocalUserManager
import by.bsuir.kostya.kichigin.domain.model.NasaEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.UUID

class MockManagerImpl(private val dataSource: LocalNasaEventDataSource): LocalUserManager {
    override fun getNasaEvents(): Flow<List<NasaEvent>> = dataSource.getNasaEvents()
    override fun getNasaEvent(eventId: UUID?): Flow<NasaEvent?> = eventId?.let{dataSource.getNasaEvent(eventId)}?: flowOf(null)
    override suspend fun upsertNasaEvent(event: NasaEvent) = dataSource.upsertNasaEvent(event)
    override suspend fun deleteNasaEvent(eventId: UUID) = dataSource.deleteNasaEvent(eventId)
}

// class UUIDConverter {
//    @TypeConverter
//    fun fromUUID(uuid: UUID?): String? {
//        return uuid?.toString()
//    }
//
//    @TypeConverter
//    fun toUUID(uuidString: String?): UUID? {
//        return UUID.fromString(uuidString)
//    }
//}