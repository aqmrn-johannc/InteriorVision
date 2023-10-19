package com.example.interiorvisioniv.fragments.loginregister

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
//import androidx.fragment.app.viewModels
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.activities.ShopActivity
import com.example.interiorvisioniv.databinding.FragmentLoginBinding
import com.example.interiorvisioniv.helper.DBHelper


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btLogin: Button
    private lateinit var db: DBHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = binding.etLoginEmail
        password = binding.etLoginPassword

        db = DBHelper(requireContext())

        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_accountOptionsFragment)
        }


        binding.btnLoginPage.setOnClickListener {
            val email = email.text.toString().trim()
            val password = password.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(requireContext(), "Field/s cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else if (!isEmailValid(email)) {
            Toast.makeText(requireContext(), "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            else if (password.length < 6) {
            Toast.makeText(requireContext(), "Password should be at least 6 characters long", Toast.LENGTH_SHORT).show()
            }
            else {
                val checkUser = db.checkUser(email, password)
                if (checkUser==true) {
                    Toast.makeText(requireContext(), "You have successfully logged in", Toast.LENGTH_SHORT).show()
                    Intent(requireActivity(), ShopActivity::class.java).also { intent ->
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    }
                }
                else {
                    Toast.makeText(requireContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPassFragment)
        }
    }

    fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}