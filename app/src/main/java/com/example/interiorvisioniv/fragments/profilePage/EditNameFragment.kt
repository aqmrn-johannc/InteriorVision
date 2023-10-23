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
import com.example.interiorvisioniv.databinding.FragmentEditNameBinding
import com.example.interiorvisioniv.helper.DBHelper

class EditNameFragment : Fragment() {

    private lateinit var binding: FragmentEditNameBinding

    private lateinit var db: DBHelper
    private lateinit var etNewName: EditText
    private lateinit var btnSave: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditNameBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        db = DBHelper(requireContext())
//        etNewName = view.findViewById(R.id.etNewName)
//        btnSave = view.findViewById(R.id.btnSave)
//        val receivedBundle = arguments
//        val userEmail = receivedBundle?.getString("userEmail") // Replace "key" with the key you used in the activity

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_editNameFragment_to_accountSettingsFragment)
        }

//        if (userEmail != null) {
//            btnSave.setOnClickListener {
//
//                db = DBHelper(requireContext())
//                etNewName = view.findViewById(R.id.etNewName)
//                btnSave = view.findViewById(R.id.btnSave)
//
//                btnSave.setOnClickListener {
//                    val newName = etNewName.text.toString()
//
//                    if (newName.isNotEmpty()) {
//                        val isUpdated = db.updateUserNameByEmail(userEmail, newName)
//
//                        if (isUpdated) {
//                            Toast.makeText(requireContext(), "Successfully updated user's name", Toast.LENGTH_SHORT).show()
//                            findNavController().navigate(R.id.action_editNameFragment_to_accountSettingsFragment)
//                        } else {
//                            Toast.makeText(requireContext(), "Failed to update name", Toast.LENGTH_SHORT).show()
//                        }
//                    } else {
//                        Toast.makeText(requireContext(), "Name cannot be empty", Toast.LENGTH_SHORT).show()
//                    }
//
//                }
//            }
//        }


    }
}