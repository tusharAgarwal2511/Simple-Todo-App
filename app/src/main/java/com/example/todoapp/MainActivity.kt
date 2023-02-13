package com.example.todoapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.databinding.TaskItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding // binding

    private lateinit var taskItemBinding : TaskItemBinding

    private lateinit var taskListRecyclerviewAdapter : TaskListRecyclerViewAdapter // adapter for taskListRecyclerView

    private lateinit var taskList : ArrayList<TaskModal> // array list of task modal

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        taskItemBinding = TaskItemBinding.inflate(layoutInflater)

        taskList = ArrayList()


        // initializing the recycler view
        taskListRecyclerviewAdapter = TaskListRecyclerViewAdapter(this, taskList)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.saveTask.setOnClickListener {


        binding.recyclerview.adapter = taskListRecyclerviewAdapter

            if(binding.task.text.toString() != ""){

                taskList.add(TaskModal(taskName = binding.task.text.toString(), false))
                binding.task.setText("")
                taskListRecyclerviewAdapter.notifyDataSetChanged()
                Toast.makeText(this, "New Task Added", Toast.LENGTH_SHORT).show()
            }

            else{
                Toast.makeText(this, "Please Enter a task", Toast.LENGTH_SHORT).show()
            }

        }

    }

}