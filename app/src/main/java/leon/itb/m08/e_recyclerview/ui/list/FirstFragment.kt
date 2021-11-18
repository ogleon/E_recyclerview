package leon.itb.m08.e_recyclerview.ui.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import leon.itb.m08.e_recyclerview.OnClickListener
import leon.itb.m08.e_recyclerview.adapter.AttendanceAdapter
import leon.itb.m08.e_recyclerview.databinding.FragmentFirstBinding
import leon.itb.m08.e_recyclerview.model.Attendance
import leon.itb.m08.e_recyclerview.model.AttendanceViewModel

class FirstFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var attendanceAdapter: AttendanceAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private val model: AttendanceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attendanceAdapter = AttendanceAdapter(model.attendanceList.value!!, this)
        linearLayoutManager = LinearLayoutManager(context)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = attendanceAdapter
        }

        model.attendanceList.observe(viewLifecycleOwner, {
            attendanceAdapter.notifyDataSetChanged()
        })

    }

    override fun onClick(attendance: Attendance) {
//        model.select(attendance)
//        parentFragmentManager.beginTransaction().apply {
//            replace(R.id.nav_host_fragment_content_main, DetailFragment())
//            setReorderingAllowed(true)
//            addToBackStack(null)
//            commit()
//        }

    }

}