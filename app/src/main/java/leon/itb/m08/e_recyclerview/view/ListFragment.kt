package leon.itb.m08.e_recyclerview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import leon.itb.m08.e_recyclerview.R
import leon.itb.m08.e_recyclerview.databinding.FragmentFirstBinding
import leon.itb.m08.e_recyclerview.model.Attendance
import leon.itb.m08.e_recyclerview.model.AttendanceAdapter
import leon.itb.m08.e_recyclerview.model.OnClickListener
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFragment : Fragment() , OnClickListener{

    private lateinit var binding: FragmentFirstBinding
    private lateinit var attendanceAdapter: AttendanceAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attendanceAdapter = AttendanceAdapter(getAttendanceList(), this)
        linearLayoutManager = LinearLayoutManager(context)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = attendanceAdapter
        }
    }

    private fun getAttendanceList(): MutableList<Attendance> {
        val attendanceList = mutableListOf<Attendance>()

        val date = Calendar.getInstance().time

        attendanceList.add(Attendance("Pol", R.string.test, date))
        attendanceList.add(Attendance("Pol", R.string.test, date))
        attendanceList.add(Attendance("Pol", R.string.test, date))
        attendanceList.add(Attendance("Pol", R.string.test, date))
        attendanceList.add(Attendance("Pol", R.string.test, date))
        attendanceList.add(Attendance("Pol", R.string.test, date))
        attendanceList.add(Attendance("Pol", R.string.test, date))

        return attendanceList
    }

    override fun onClick(attendance: Attendance) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_container, MissedAttendanceFragment())
            setReorderingAllowed(true)
            addToBackStack(null)
            commit()
        }
    }

}