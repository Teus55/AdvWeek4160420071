package com.advweek4160420071.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.advweek4160420071.databinding.FragmentStudentDetailBinding
import com.advweek4160420071.model.Student
import com.advweek4160420071.viewmodel.DetailViewModel


class StudentDetailFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStudentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
                student ->
            binding.txtID.setText(student.id)
            binding.txtName.setText(student.name)
            binding.txtBod.setText(student.bod)
            binding.txtPhone.setText(student.phone)
        })
    }
}