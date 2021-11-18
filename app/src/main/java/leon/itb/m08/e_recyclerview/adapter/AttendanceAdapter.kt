package leon.itb.m08.e_recyclerview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import leon.itb.m08.e_recyclerview.OnClickListener
import leon.itb.m08.e_recyclerview.R
import leon.itb.m08.e_recyclerview.databinding.ItemAttendanceBinding
import leon.itb.m08.e_recyclerview.model.Attendance

class AttendanceAdapter(
    private val listAttendance: MutableList<Attendance>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<AttendanceAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_attendance, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val a = listAttendance[position]
        with(holder) {
            setListener(a)
            binding.tvRvNameValue.text = a.name
            binding.tvRvDateValue.text = a.date

            if (a.subject == 0) {
                binding.tvRvSubjectValue.text = "M07"
            } else {
                binding.tvRvSubjectValue.text = "M08"
            }

            if (a.isJustified) {
                binding.justifiedImageView.setImageResource(R.drawable.ic_true)
            } else {
                binding.justifiedImageView.setImageResource(R.drawable.ic_false)
            }

        }
    }


    override fun getItemCount(): Int {
        return listAttendance.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemAttendanceBinding.bind(view)

        fun setListener(attendance: Attendance) {
            binding.root.setOnClickListener {
                listener.onClick(attendance)
            }
        }
    }

}
