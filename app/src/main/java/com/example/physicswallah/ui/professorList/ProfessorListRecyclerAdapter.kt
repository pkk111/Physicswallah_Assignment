package com.example.physicswallah.ui.professorList

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.physicswallah.Data.ProfessorsData.ProfessorModel
import com.example.physicswallah.databinding.ProfessorDisplayItemcardBinding

class ProfessorListRecyclerAdapter() :
    RecyclerView.Adapter<ProfessorListRecyclerAdapter.ViewHolder>() {

    private var professorList = mutableListOf<ProfessorModel>()

    fun setProfessorList(professorList: List<ProfessorModel>) {
        this.professorList = professorList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfessorListRecyclerAdapter.ViewHolder {
        return ViewHolder(
            ProfessorDisplayItemcardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfessorListRecyclerAdapter.ViewHolder, position: Int) {
        val professor = professorList[position]
        holder.name.text = professor.name

        var subject: String = ""
        var qualification: String = ""
        if (!professor.subjects.isNullOrEmpty()) {
            subject = professor.subjects[0]
            for (i in 1 until professor.subjects.size)
                subject += ", ${professor.subjects[i]}"
        }
        holder.subjects.text = subject

        if (!professor.qualifications.isNullOrEmpty()) {
            qualification = professor.qualifications[0]
            for (i in 1 until professor.qualifications.size)
                qualification += ", ${professor.qualifications[i]}"
        }
        holder.qualifications.text = qualification
//        if(!professor.profilePic.isNullOrEmpty() || professor.profilePic!=null) {
//            holder.image.load(professor.profilePic)
//        }
    }

    override fun getItemCount(): Int = professorList.size

    inner class ViewHolder(binding: ProfessorDisplayItemcardBinding) :
        RecyclerView.ViewHolder(binding.root) {
//        val image = binding.imageView
        val name = binding.name
        val subjects = binding.subject
        val qualifications = binding.qualification
    }
}