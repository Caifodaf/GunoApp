package ru.android.emotionapp.uitilits

import android.os.Handler
import io.reactivex.Observable
import java.lang.Exception

data class parserUrl(
    var url: String
)

interface  ParserDebug {

    //fun setUrl(url: String?) {}
//
    //fun load(callback: Runnable) {
    //    Observable.create<parserUrl>{subscriber ->
    //        try {
    //            subscriber.onNext(loadUrl())
    //        }catch (e: Exception){
    //            subscriber.onError(e)
    //        }
    //        subscriber.onComplete()
    //    }
    //}
//
    //private fun loadUrl(): parserUrl {
    //    Handler().postDelayed(
    //    {
    //        val data = MutableList<parserUrl>()
    //        return@postDelayed
    //    }, 3000)
    //}
}