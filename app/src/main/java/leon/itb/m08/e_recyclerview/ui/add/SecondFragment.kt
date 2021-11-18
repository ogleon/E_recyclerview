package leon.itb.m08.e_recyclerview.ui.add

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import leon.itb.m08.e_recyclerview.R
import leon.itb.m08.e_recyclerview.databinding.FragmentSecondBinding
import leon.itb.m08.e_recyclerview.model.Attendance
import leon.itb.m08.e_recyclerview.model.AttendanceViewModel
import leon.itb.m08.e_recyclerview.ui.list.FirstFragment
import java.util.*

class SecondFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentSecondBinding
    private val model: AttendanceViewModel by activityViewModels()
    private lateinit var attendance: Attendance

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(inflater, container, false)

        /*set an adapter with strings array*/
        binding.spinnerDetails.adapter = activity?.let {
            ArrayAdapter(
                it,
                R.layout.support_simple_spinner_dropdown_item,
                resources.getStringArray(R.array.subjectsArray)
            )
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdd.setOnClickListener {

            attendance = Attendance(
                binding.editTextTextPersonName.text.toString().trim(),
                binding.spinnerDetails.selectedItemPosition,
                Calendar.getInstance().time.toString(),
                binding.checkboxJustified.isChecked
            )
            model.addAttendance(attendance)
            showPauseDialog()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    private fun showPauseDialog() {
        val alertDialog = AlertDialog.Builder(this.context)
        alertDialog.apply {
            setMessage(
                "Name: " +
                        attendance.name
                        + "\n" +
                        "Subject: " +
                        attendance.subject
                        + "\n" +
                        "Date: " +
                        attendance.date
                        + "\n" +
                        "IsJustified: " +
                        attendance.isJustified
            )

            setPositiveButton("Ok") { _, _ ->
                val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
                ft.replace(R.id.nav_host_fragment_content_main, FirstFragment())
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ft.addToBackStack(null)
                ft.commit()
            }
        }.create().show()
    }

}