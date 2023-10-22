package com.example.interiorvisioniv.fragments.profilePage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.databinding.FragmentEditEmailBinding

class EditEmailFragment : Fragment() {

    private lateinit var binding: FragmentEditEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditEmailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_editEmailFragment_to_accountSettingsFragment)
        }
    }
}