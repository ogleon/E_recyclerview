package leon.itb.m08.e_recyclerview.model

import android.os.Parcelable
import java.util.*

@kotlinx.parcelize.Parcelize
data class Attendance (var nameStudent: String = "Marc", var subject: Int, var date: Date, var isJustified: Boolean = true) : Parcelable