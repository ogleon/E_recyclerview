package leon.itb.m08.e_recyclerview.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import leon.itb.m08.e_recyclerview.R
import leon.itb.m08.e_recyclerview.databinding.ItemAttendanceBinding

class AttendanceAdapter(
    private val listAttendance: List<Attendance>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<AttendanceAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemAttendanceBinding.bind(view)
        fun setListener(attendance: Attendance) {
            binding.root.setOnClickListener {
                listener.onClick(attendance)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_attendance, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val attendance = listAttendance[position]
        with(holder) {
            setListener(attendance)
            binding.tvRvNameValue.text
            binding.tvRvSubjectValue.text
            binding.tvRvDateValue.text
            binding.justifiedImageView.backgroundTintList
        }
    }

    override fun getItemCount(): Int {
        return listAttendance.size
    }
}
