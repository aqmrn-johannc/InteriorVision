package com.example.interiorvisioniv.fragments.profilePage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.databinding.FragmentAccountSettingsBinding
import com.example.interiorvisioniv.helper.DBHelper

class AccountSettingsFragment : Fragment() {

    private lateinit var binding: FragmentAccountSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountSettingsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_accountSettingsFragment_to_profileFragment)
        }

        binding.btEditName.setOnClickListener {
            findNavController().navigate(R.id.action_accountSettingsFragment_to_editNameFragment)
        }

        binding.btEditEmail.setOnClickListener {
            findNavController().navigate(R.id.action_accountSettingsFragment_to_editEmailFragment)
        }

        binding.btChangePassword.setOnClickListener {
            findNavController().navigate(R.id.action_accountSettingsFragment_to_changePasswordFragment)
        }

    }
}
