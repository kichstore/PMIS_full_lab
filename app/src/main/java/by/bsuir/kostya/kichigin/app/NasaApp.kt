package by.bsuir.kostya.kichigin.app

import android.app.Application
import by.bsuir.kostya.kichigin.data.LocalNasaEventDataSource
import by.bsuir.kostya.kichigin.data.RoomEventDataSource
import by.bsuir.kostya.kichigin.data.local.AppDatabase
import by.bsuir.kostya.kichigin.data.local.DbEventMapper
import by.bsuir.kostya.kichigin.data.manager.MockManagerImpl
import by.bsuir.kostya.kichigin.domain.manager.LocalUserManager
import by.bsuir.kostya.kichigin.events.edit.editEventsViewModelModule
import by.bsuir.kostya.kichigin.events.home.homeViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module


val dataModule = module {
}

val domainModule = module {

}

val appModule = module {
    single { AppDatabase(context = get()).eventDao() }
    single<LocalNasaEventDataSource> { RoomEventDataSource(get(), DbEventMapper()) }
    single<LocalUserManager> { MockManagerImpl(get()) }
    includes(dataModule, domainModule, homeViewModelModule, editEventsViewModelModule)
}

class NasaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(appModule)
        }
    }
}
