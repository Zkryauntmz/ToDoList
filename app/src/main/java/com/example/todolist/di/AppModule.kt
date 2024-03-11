package com.example.todolist.di

import android.content.Context
import androidx.room.Room
import com.example.todolist.data.datasource.NotlarDataSource
import com.example.todolist.data.repo.NotlarRepository
import com.example.todolist.room.NotlarDao
import com.example.todolist.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideNotlarRepository(nds:NotlarDataSource): NotlarRepository {
    return NotlarRepository(nds)
    }
    @Provides
    @Singleton
    fun provideNotlarDatasource(ndao :NotlarDao):NotlarDataSource{
        return NotlarDataSource(ndao)
    }



    @Provides
    @Singleton
    fun provideNotlarDao(@ApplicationContext context: Context):NotlarDao{
    val vt = Room.databaseBuilder(context,Veritabani::class.java,"todolist.sqlite")
        .createFromAsset("todolist.sqlite").build()
        return vt.getNotlarDao()
    }
}