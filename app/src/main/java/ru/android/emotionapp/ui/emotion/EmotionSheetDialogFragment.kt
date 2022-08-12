package ru.android.emotionapp.ui.emotion

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.room.Room
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.*
import ru.android.emotionapp.R
import ru.android.emotionapp.databinding.BottomSheetEmotionBinding
import ru.android.emotionapp.sqlData.AppDatabase
import ru.android.emotionapp.sqlData.DataProvider
import ru.android.emotionapp.sqlData.EmotionCalendar
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


private const val COLLAPSED_HEIGHT = 225

class EmotionSheetDialogFragment : BottomSheetDialogFragment(),DataProvider {

    // Можно обойтись без биндинга и использовать findViewById
    lateinit var binding: BottomSheetEmotionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = BottomSheetEmotionBinding.bind(inflater.inflate(R.layout.bottom_sheet_emotion, container))
        return binding.root
    }

    private lateinit var db: AppDatabase

    override fun onStart() {
        super.onStart()

        val density = requireContext().resources.displayMetrics.density

        dialog?.let {
            val bottomSheet = it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val behavior = BottomSheetBehavior.from(bottomSheet)

            seekBarMoodTracker(binding.seekbarOne)

            initQB()

            initBtnSave(binding.tvBtnNextStage)

            //behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            //    override fun onStateChanged(bottomSheet: View, newState: Int) {
            //        // Нам не нужны действия по этому колбеку
            //    }
//
            //    override fun onSlide(bottomSheet: View, slideOffset: Float) {
            //    }
//
            //})
        }
    }

    private fun initBtnSave(btn: TextView) {
        btn.setOnClickListener(){
            val currentDate = Date()
            val dateFormat: DateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            //val dateText: String = dateFormat.format(currentDate)
            val emotionDay:EmotionCalendar = EmotionCalendar()

            if (checkCurrentDateLoad(dateFormat.format(currentDate)).isNullOrEmpty()){
                emotionDay.date = dateFormat.format(currentDate)
                emotionDay.moodStatus = binding.seekbarOne.progress
                emotionDay.energyStatus = binding.seekbarTwo.progress
                emotionDay.additionalComment = ""

                saveSqlData(emotionDay,db)
            }else{
                emotionDay.date = dateFormat.format(currentDate)
                emotionDay.moodStatus = binding.seekbarOne.progress
                emotionDay.energyStatus = binding.seekbarTwo.progress
                emotionDay.additionalComment = ""

                updateSqlData(emotionDay,db)
            }
        }
    }

    private fun checkCurrentDateLoad(date: String): String {
        var value = "Current"
        CoroutineScope(Dispatchers.IO).launch {
            value = GlobalScope.async(Dispatchers.IO) {
                db.emotionCalendarDao.checkCurrentDate(date)
            }.await().toString()
        }
        return value
    }

    private fun initQB() = GlobalScope.launch(Dispatchers.IO) {
        db = Room.databaseBuilder(
            requireContext().applicationContext,
            AppDatabase::class.java, "calendar-database"
        ).build()
    }



    private fun seekBarMoodTracker(seekBar: SeekBar) {
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Todo add change Icon
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }



}