package com.zobaze.zobazerefractortask.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.zobaze.zobazerefractortask.databinding.ViewEmployeeListItemBinding
import com.zobaze.zobazerefractortask.domain.entity.Employee

internal class EmployeeListAdapter :
    ListAdapter<Employee, EmployeeListAdapter.EmployeeVH>(Employee_DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeVH =
        EmployeeVH(parent)

    override fun onBindViewHolder(holder: EmployeeVH, position: Int) {
        holder.bind(getItem(position))
    }

    class EmployeeVH(private val binding: ViewEmployeeListItemBinding) : ViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            ViewEmployeeListItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(data: Employee) {
            binding.apply {
                textEmpId.text = data.id.toString()
                textEmpName.text = data.name
            }
        }
    }

    private companion object Employee_DiffCallback : DiffUtil.ItemCallback<Employee>() {
        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean =
            oldItem == newItem

        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean =
            oldItem.id == newItem.id
    }
}