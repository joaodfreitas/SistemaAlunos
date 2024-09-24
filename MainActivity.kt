package com.example.app

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.app.Student
import com.example.app.StudentAdapter
import com.example.verificadordeidade.R
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextArea: EditText
    private lateinit var buttonAdd: Button
    private lateinit var listViewStudents: ListView
    private lateinit var textViewCount: TextView
    private lateinit var buttonClear: Button

    private val students = mutableListOf<Student>()
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextArea = findViewById(R.id.editTextArea)
        buttonAdd = findViewById(R.id.buttonAdd)
        listViewStudents = findViewById(R.id.listViewStudents)
        textViewCount = findViewById(R.id.textViewCount)
        buttonClear = findViewById(R.id.buttonClear)

        adapter = StudentAdapter(this, students)
        listViewStudents.adapter = adapter

        buttonAdd.setOnClickListener {
            val name = editTextName.text.toString()
            val area = editTextArea.text.toString()

            if (name.isNotEmpty() && area.isNotEmpty()) {
                val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                students.add(Student(name, area, currentDate))

                adapter.notifyDataSetChanged()
                updateStudentCount()

                editTextName.text.clear()
                editTextArea.text.clear()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        buttonClear.setOnClickListener {
            students.clear()
            adapter.notifyDataSetChanged()
            updateStudentCount()
        }
    }

    private fun updateStudentCount() {
        textViewCount.text = "Total de Alunos: ${students.size}"
    }
}