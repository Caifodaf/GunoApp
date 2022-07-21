package ru.android.emotionapp.ui.emotion

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.android.emotionapp.R
import ru.android.emotionapp.databinding.BottomSheetEmotionBinding

private const val COLLAPSED_HEIGHT = 225

class EmotionSheetDialogFragment : BottomSheetDialogFragment() {

    // Можно обойтись без биндинга и использовать findViewById
    lateinit var binding: BottomSheetEmotionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = BottomSheetEmotionBinding.bind(inflater.inflate(R.layout.bottom_sheet_emotion, container))
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val density = requireContext().resources.displayMetrics.density

        dialog?.let {
            val bottomSheet = it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val behavior = BottomSheetBehavior.from(bottomSheet)

            // Выставляем высоту для состояния collapsed и выставляем состояние collapsed
            //behavior.peekHeight = (COLLAPSED_HEIGHT * density).toInt()
            //behavior.state = BottomSheetBehavior.STATE_COLLAPSED

            behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    // Нам не нужны действия по этому колбеку
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                }

            })
        }
    }

}