package ru.android.emotionapp.ui.settings

import android.os.UserManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.android.emotionapp.uitilits.ParserDebug
import ru.android.emotionapp.uitilits.parserUrl
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(): ViewModel(),ParserDebug {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun printName(){
        val myObservable = getObservable()
        val myObserver = getObserver()

        myObservable.subscribe(myObserver)

        load()
    }

}