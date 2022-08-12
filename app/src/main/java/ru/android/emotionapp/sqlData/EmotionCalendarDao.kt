package ru.android.emotionapp.sqlData

import androidx.room.*

@Dao
interface EmotionCalendarDao {

    @Insert
    fun insertAll(vararg emotion: EmotionCalendar?)

    @Delete
    fun delete(emotion: EmotionCalendar?)

    @Update
    fun update(emotion: EmotionCalendar?)

    @get:Query("SELECT * FROM emotionCalendar")
    val allCalendar: List<EmotionCalendar>

    // // Получение всех Person из бд с условием
     @Query("SELECT * FROM emotionCalendar WHERE date LIKE :date")
     fun checkCurrentDate(date: String): List<EmotionCalendar?>?
}