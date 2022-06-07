package com.nicootech.employeesinfo.ui.adapter

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.nicootech.employeesinfo.R
import com.nicootech.employeesinfo.databinding.EmployeeRowBinding
import com.nicootech.employeesinfo.model.Employee



class EmployeeListItemViewHolder(private val binding: EmployeeRowBinding):
    RecyclerView.ViewHolder(binding.root)
{
    private val imageView = binding.circleIv
    private val fullNameTextView = binding.nameTv
    private val teamTextView = binding.teamTv

    fun bind(employee: Employee) {
        val context = binding.root.context

        Glide.with(context)
            .load(employee.photos)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .override(binding.circleIv.measuredWidth)
            .placeholder(R.drawable.photo_placeholder)
            .error(R.drawable.photo_error)
            .circleCrop()
            .into(object :CustomTarget<Drawable>(){
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    imageView.setImageDrawable(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    imageView.setImageDrawable(placeholder)
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    imageView.setImageDrawable(errorDrawable)
                }

            })

        fullNameTextView.text = employee.name
        teamTextView.text = employee.team

    }

}

