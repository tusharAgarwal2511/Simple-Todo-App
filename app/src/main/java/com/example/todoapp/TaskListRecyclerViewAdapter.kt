package com.example.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.TaskItemBinding

class TaskListRecyclerViewAdapter(private val context : Context, private val taskList : ArrayList<TaskModal> ) : RecyclerView.Adapter<TaskListRecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(val binding : TaskItemBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        val view = TaskItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() : Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {

        val temp = taskList[position] // temporarily stores the taskList object at current position
        holder.binding.taskName.text = temp.taskName

        holder.binding.isDone.setOnCheckedChangeListener { compoundButton, b ->

            if(holder.binding.isDone.isChecked) {

                holder.binding.taskCard.setBackgroundResource(R.drawable.task_card_background_done)
                holder.binding.done.isVisible = true
                Toast.makeText(context, "Task Completed👍", Toast.LENGTH_SHORT).show()

            }
            else{
                holder.binding.taskCard.setBackgroundResource(R.drawable.task_card_background)
                holder.binding.done.isVisible = false

            }
        }

        holder.binding.isDeleted.setOnCheckedChangeListener { compoundButton, b ->

            taskList.removeAt(position)
            notifyDataSetChanged()

        }


    }

}