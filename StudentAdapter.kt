package com.example.app


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.verificadordeidade.R

class StudentAdapter(private val context: Context, private val students: List<Student>) : BaseAdapter() {

    override fun getCount(): Int = students.size

    override fun getItem(position: Int): Any = students[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.student_item, parent, false)

        val student = students[position]
        val textViewStudentInfo = view.findViewById<TextView>(R.id.textViewStudentInfo)
        val textViewDateAdded = view.findViewById<TextView>(R.id.textViewDateAdded)

        textViewStudentInfo.text = "${student.name} - ${student.area}"
        textViewDateAdded.text = "Adicionado em: ${student.date}"

        return view
    }
}