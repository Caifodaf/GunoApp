package ru.android.emotionapp.sqlData

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [EmotionCalendar::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val emotionCalendarDao: EmotionCalendarDao
}