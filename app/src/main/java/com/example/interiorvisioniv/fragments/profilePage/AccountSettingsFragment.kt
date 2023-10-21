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

    private lateinit var nameData: EditText
    private lateinit var emailData: EditText
    private lateinit var currentPassData: EditText
    private lateinit var newPassData: EditText
    private lateinit var reTypePassData: EditText
    private lateinit var btSaveChanges: Button
    private lateinit var btSaveName: Button
    private lateinit var btSaveEmail: Button
    private lateinit var db: DBHelper

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

        db = DBHelper(requireContext())
        nameData = binding.etEditName
        emailData = binding.etEditEmail
        currentPassData = binding.etCurrentPassword
        newPassData = binding.etChangePassword
        reTypePassData = binding.etReTypePassword
        btSaveChanges = binding.btnSaveChanges

        // Retrieve the user's email from the arguments
        val userEmail = arguments?.getString("userEmail")

        btSaveChanges.setOnClickListener {
            val name = nameData.text.toString()
            val email = emailData.text.toString()
            val currentPass = currentPassData.text.toString()
            val newPass = newPassData.text.toString()
            val reTypePass = reTypePassData.text.toString()

            if (newPass.isNotEmpty() || reTypePass.isNotEmpty()) {
                if (newPass != reTypePass) {
                    Toast.makeText(requireContext(), "New password does not match", Toast.LENGTH_SHORT).show()
                } else if (userEmail != null && !db.checkUser(userEmail, currentPass)) {
                    Toast.makeText(requireContext(), "Incorrect current password", Toast.LENGTH_SHORT).show()
                } else if (userEmail != null && db.updatePass(userEmail, newPass)) {
                    Toast.makeText(requireContext(), "Successfully updated password", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Failed to update password", Toast.LENGTH_SHORT).show()
                }
            } else {
                var updateSuccessful = true

                if (name.isNotEmpty()) {
                    if (userEmail != null && db.updateName(userEmail, name)) {
                        Toast.makeText(requireContext(), "Successfully updated user's name", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireContext(), "Failed to update name", Toast.LENGTH_SHORT).show()
                        updateSuccessful = false
                    }
                }
                if (email.isNotEmpty()) {
                    if (userEmail != null && db.updateEmail(userEmail, email)) {
                        Toast.makeText(requireContext(), "Successfully updated email", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireContext(), "Failed to update email", Toast.LENGTH_SHORT).show()
                        updateSuccessful = false
                    }
                }

                if (updateSuccessful) {
                    Toast.makeText(requireContext(), "Successfully updated credential/s", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Failed to update credential/s", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_accountSettingsFragment_to_profileFragment)
        }
    }
}
