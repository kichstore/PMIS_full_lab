package by.bsuir.kostya.kichigin.data.remote

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class NetworkEvents(
    val eventId: UUID,
    @SerializedName("name")//добавить в соответствии с jsonoм
    val name: String? = null,
    val date: String? = null,
    val type: String? = null,
    val description: String? = null,
    val notes: String? = null
)