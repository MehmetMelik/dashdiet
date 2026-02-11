package com.dashdiet.app.di

import android.content.Context
import com.dashdiet.app.data.repository.MealPlanRepository
import com.dashdiet.app.data.repository.RecipeRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideRecipeRepository(): RecipeRepository = RecipeRepository()

    @Provides
    @Singleton
    fun provideMealPlanRepository(): MealPlanRepository = MealPlanRepository()
}
