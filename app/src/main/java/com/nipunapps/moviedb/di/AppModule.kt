package com.nipunapps.moviedb.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.nipunapps.moviedb.feature_auth.data.remote.FirestoreManager
import com.nipunapps.moviedb.feature_auth.data.repository.RegisterRepositoryImpl
import com.nipunapps.moviedb.feature_auth.domain.repository.RegisterRepository
import com.nipunapps.moviedb.first_time_display.data.local.dto.FirstTimeDisplaySettings
import com.nipunapps.moviedb.first_time_display.data.local.serializer.FirstTimeDisplaySerializer
import com.nipunapps.moviedb.first_time_display.data.repository.FirstTimeDisplayRepositoryImpl
import com.nipunapps.moviedb.first_time_display.domain.repository.FirstTimeDisplayRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val Context.dataSource by dataStore("app-remember", FirstTimeDisplaySerializer)

    @Provides
    @Singleton
    fun provideDataSource(
        @ApplicationContext context: Context
    ): DataStore<FirstTimeDisplaySettings> {
        return context.dataSource
    }

    @Provides
    @Singleton
    fun provideFirstTimeDisplaySettingRepo(
        dataStore: DataStore<FirstTimeDisplaySettings>
    ): FirstTimeDisplayRepository {
        return FirstTimeDisplayRepositoryImpl(dataStore)
    }

    @Provides
    @Singleton
    fun provideRegisterRepository(

    ): RegisterRepository = RegisterRepositoryImpl(FirestoreManager())
}