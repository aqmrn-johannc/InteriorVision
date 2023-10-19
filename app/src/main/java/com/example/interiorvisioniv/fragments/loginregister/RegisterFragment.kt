package com.example.interiorvisioniv.fragments.loginregister

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.databinding.FragmentRegisterBinding
import com.example.interiorvisioniv.helper.DBHelper

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var btSignUp: Button
    private lateinit var db: DBHelper


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name = binding.etRegistrationName
        email = binding.etRegistrationEmail
        password = binding.etRegistrationPassword
        confirmPassword = binding.etConfirmPassword
        btSignUp = binding.btnSignUp
        db = DBHelper(requireContext())

        binding.tvLogIn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_accountOptionsFragment)
        }

        btSignUp.setOnClickListener {

            val name = name.text.toString()
            val email = email.text.toString().trim()
            val password = password.text.toString()
            val confirmPassword = confirmPassword.text.toString()
            val savedData = db.insertUserData(name, email, password)

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(requireContext(), "Field/s cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else if (!isEmailValid(email)) {
                Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            else if (password.length < 6) {
                Toast.makeText(requireContext(), "Password should be at least 6 characters long", Toast.LENGTH_SHORT).show()
            }
            else {
                if (password == confirmPassword) {
                    if (savedData) {
                        Toast.makeText(requireContext(), "Sign up successful", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                    }
                    else {
                        Toast.makeText(requireContext(), "User already exists", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(requireContext(), "Password does not match", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}