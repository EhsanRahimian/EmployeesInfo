package com.nicootech.employeesinfo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nicootech.employeesinfo.databinding.EmployeeRowBinding
import com.nicootech.employeesinfo.model.Employee


class EmployeeListAdapter() : ListAdapter<Employee, RecyclerView.ViewHolder>(differCallback) {

    private lateinit var binding: EmployeeRowBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = EmployeeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeListItemViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = viewHolder as EmployeeListItemViewHolder
        val employee = getItem(position)
        holder.bind(employee)
    }


}
private val differCallback = object : DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.uuid == newItem.uuid
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem == newItem
    }

}


