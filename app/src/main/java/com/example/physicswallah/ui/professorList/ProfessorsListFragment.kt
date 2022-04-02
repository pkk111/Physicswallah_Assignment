package com.example.physicswallah.ui.professorList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.physicswallah.Data.ProfessorsData.ProfessorModel
import com.example.physicswallah.R
import com.example.physicswallah.databinding.ProfessorsListFragmentBinding

class ProfessorsListFragment : Fragment() {

    companion object {
        fun newInstance() = ProfessorsListFragment()
    }
    private lateinit var binding: ProfessorsListFragmentBinding
    private lateinit var viewModel: ProfessorListViewModel
    private lateinit var professorListRecyclerAdapter: ProfessorListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfessorsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        professorListRecyclerAdapter = ProfessorListRecyclerAdapter()
        binding.professorsListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.professorsListRecyclerView.adapter = professorListRecyclerAdapter

        viewModel = ViewModelProvider(this)[ProfessorListViewModel::class.java]
        viewModel.getAllProfessors()

        // looking for any errors which might happen in view model or further layers
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.professorsList.observe(viewLifecycleOwner){
            professorListRecyclerAdapter.setProfessorList(it)
        }
    }

}