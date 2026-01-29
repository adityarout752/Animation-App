package com.animeapp.di

import android.app.Application
import androidx.room.Room
import com.animeapp.data.local.AnimeDao
import com.animeapp.data.local.AnimeDatabase
import com.animeapp.data.remote.JikanApi
import com.animeapp.data.repository.AnimeRepositoryImpl
import com.animeapp.domain.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideJikanApi(okHttpClient: OkHttpClient): JikanApi {
        return Retrofit.Builder()
            .baseUrl(JikanApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JikanApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimeDatabase(app: Application): AnimeDatabase {
        return Room.databaseBuilder(
            app,
            AnimeDatabase::class.java,
            AnimeDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideAnimeDao(database: AnimeDatabase): AnimeDao {
        return database.animeDao()
    }

    @Provides
    @Singleton
    fun provideAnimeRepository(
        api: JikanApi,
        dao: AnimeDao
    ): AnimeRepository {
        return AnimeRepositoryImpl(api, dao)
    }
}
