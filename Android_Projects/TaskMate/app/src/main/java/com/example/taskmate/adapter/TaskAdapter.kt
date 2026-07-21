package com.example.taskmate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmate.R
import com.example.taskmate.model.Task


   class TaskAdapter(
    private val taskList: ArrayList<Task>
        ) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.taskTitle)
        val description: TextView = itemView.findViewById(R.id.taskDescription)
        val checkBox: CheckBox = itemView.findViewById(R.id.taskCheckBox)

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)

        return TaskViewHolder(view)
    }


    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {

        val task = taskList[position]

        holder.title.text = task.title
        holder.description.text = task.description
        holder.checkBox.isChecked = task.isCompleted
        if(task.isCompleted){

            holder.title.paintFlags =
                holder.title.paintFlags or
                        android.graphics.Paint.STRIKE_THRU_TEXT_FLAG

        }
        else{

            holder.title.paintFlags =
                holder.title.paintFlags and
                        android.graphics.Paint.STRIKE_THRU_TEXT_FLAG.inv()

        }


        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->

            task.isCompleted = isChecked

            notifyItemChanged(position)

        }

    }


    override fun getItemCount(): Int {

        return taskList.size

    }
}