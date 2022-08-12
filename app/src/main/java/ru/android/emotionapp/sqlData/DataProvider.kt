package ru.android.emotionapp.sqlData

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

interface DataProvider {

    fun saveSqlData(emotionDay: EmotionCalendar, db: AppDatabase) = GlobalScope.launch(Dispatchers.IO) {
        db.emotionCalendarDao.insertAll(emotionDay)
    }

    fun updateSqlData(emotionDay: EmotionCalendar, db: AppDatabase) = GlobalScope.launch(Dispatchers.IO) {
        db.emotionCalendarDao.update(emotionDay)
    }



}