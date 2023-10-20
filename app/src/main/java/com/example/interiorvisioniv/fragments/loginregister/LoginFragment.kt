package com.example.interiorvisioniv.fragments.loginregister

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.activities.LoginRegisterActivity
import com.example.interiorvisioniv.activities.ShopActivity
import com.example.interiorvisioniv.databinding.FragmentLoginBinding
import com.example.interiorvisioniv.helper.DBHelper


class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btLogin: Button
    private lateinit var db: DBHelper
    private lateinit var sp: SharedPreferences
    private lateinit var editor: Editor

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
        btLogin = binding.btnLoginPage

        db = DBHelper(requireContext())

        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_accountOptionsFragment)
        }

        sp = requireContext().getSharedPreferences("Data", Context.MODE_PRIVATE)
        editor = sp.edit()
        var login = sp.getBoolean("isLoggedIn", false)
        if (login) {
            val intent = Intent(requireActivity(), ShopActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }


        btLogin.setOnClickListener {
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
                Log.d("LoginFragment", "Email: $email, Password: $password")
                if (checkUser) {
                    if (binding.cbRememberMe.isChecked) {
                        editor.putString("email", email)
                        editor.putString("password", password)
                        editor.putBoolean("isLoggedIn", true)
                        editor.apply()
                    }
                    Toast.makeText(requireContext(), "Login Successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(requireActivity(), ShopActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(requireContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
                Log.d("LoginFragment", "checkUser result: $checkUser")
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