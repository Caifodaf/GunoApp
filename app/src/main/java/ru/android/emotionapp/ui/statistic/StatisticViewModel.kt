package ru.android.emotionapp.ui.statistic

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.android.emotionapp.sqlData.AppDatabase
import ru.android.emotionapp.sqlData.EmotionCalendar
import javax.inject.Inject

@HiltViewModel
class StatisticViewModel @Inject constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Statistic Fragment"
    }
    val text: LiveData<String> = _text

    fun dbGetAll(db: AppDatabase) {
        GlobalScope.launch(Dispatchers.IO) {
            val calendar: List<EmotionCalendar> = db.emotionCalendarDao.allCalendar
            Log.e("AAA","calendar ${calendar.size} ${calendar[calendar.size-1].date}")
            Log.e("AAA","calendar ${calendar.size} ${calendar[calendar.size-1].moodStatus}")
        }
    }

}