package ru.android.emotionapp.sqlData

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import java.util.*

@Entity
class EmotionCalendar {
    @PrimaryKey
    var date: String = ""
    var moodStatus: Int = 0
    var energyStatus: Int = 0
    var additionalComment:String? = ""
}