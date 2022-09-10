package ru.android.emotionapp.ui.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.room.Room
import dagger.hilt.android.AndroidEntryPoint
import ru.android.emotionapp.databinding.FragmentStatisticBinding
import ru.android.emotionapp.sqlData.AppDatabase

@AndroidEntryPoint
class StatisticFragment : Fragment(){

    private var _binding: FragmentStatisticBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<StatisticViewModel>()
    private lateinit var db: AppDatabase

    //private lateinit var lineChartGraphView: com.github.mikephil.charting.charts.LineChart

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        //val statisticViewModel =
        //        ViewModelProvider(this).get(StatisticViewModel::class.java)

        _binding = FragmentStatisticBinding.inflate(inflater, container, false)
        val root: View = binding.root

        db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "calendar-database"
        ).build()

        viewModel.dbGetAll(db)























//        val lineChartGraphView = binding.chart1
//
//        var valsComp1: List<Entry> = emptyList()
//        var valsComp2: List<Entry> = emptyList()
//
//        val c1e1 = Entry(19f, 2f) // 0 == quarter 1
//        val c1e2 = Entry(20f, 6f) // 1 == quarter 2 ...
//        val c1e3 = Entry(21f, 5f)
//        val c1e4 = Entry(22f, 5f)
//        val c1e5 = Entry(23f, 3f)
//        valsComp1 = listOf(c1e1,c1e2,c1e3,c1e4,c1e5,)
//
//        val setComp1 = LineDataSet(valsComp1, "Company 1")
//        setComp1.axisDependency = AxisDependency.LEFT
//        val setComp2 = LineDataSet(valsComp2, "Company 2")
//        setComp2.axisDependency = AxisDependency.LEFT
//
//        // use the interface ILineDataSet
//        val dataSets: MutableList<ILineDataSet> = ArrayList()
//        dataSets.add(setComp1)
//        //dataSets.add(setComp2)
//        val data = LineData(dataSets)
//        lineChartGraphView.data = data
//        lineChartGraphView.invalidate() // refresh
//
//
//        val quarters = arrayOf("18","19","20","21","22","23","24","25","26","27")
//        val formatter: ValueFormatter = object : ValueFormatter() {
//            override fun getAxisLabel(value: Float, axis: AxisBase): String {
//                return quarters[value.toInt()]
//            }
//        }
//        val xAxis: XAxis = lineChartGraphView.xAxis
//        xAxis.granularity = 1f // minimum axis-step (interval) is 1
//
//        xAxis.valueFormatter = formatter
//
//        lineChartGraphView.invalidate() // refresh












        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}