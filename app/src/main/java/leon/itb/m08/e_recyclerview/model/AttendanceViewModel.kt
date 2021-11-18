package leon.itb.m08.e_recyclerview.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import leon.itb.m08.e_recyclerview.R

class AttendanceViewModel: ViewModel() {

    var attendanceList = MutableLiveData<MutableList<Attendance>>().apply {
        this.value = mutableListOf(
            Attendance("Marc", R.string.test, "Thu Nov 18 20:20:32 GMT 2021", false),
            Attendance("Garcia", R.string.test2, "Thurs Nov 20 17:34:12 GMT 2021", true),
            Attendance("Perez", R.string.test2, "Thurs Nov 20 17:34:24 GMT 2021", true),
            Attendance("Lopez", R.string.test2, "Thurs Nov 20 17:34:38 GMT 2021", true)
        )
    }

    private var selectedUser = MutableLiveData<Attendance>()

    fun addAttendance(attendance: Attendance){
        attendanceList.value!!.add(attendance)
        attendanceList.postValue(attendanceList.value)
    }

    fun select(attendance: Attendance) {
        selectedUser.postValue(attendance)
        selectedUser.value = attendance
    }

}