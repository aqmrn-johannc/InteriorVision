package com.example.interiorvisioniv.fragments.loginregister

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.databinding.FragmentForgotPasswordBinding
import com.example.interiorvisioniv.helper.DBHelper

class ForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordBinding

    private lateinit var etEmail: EditText
    private lateinit var db: DBHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etEmail = binding.etEmailReset
        db = DBHelper(requireContext())

        binding.btnReset.setOnClickListener {
            val email = etEmail.text.toString()
            val checkEmail = db.checkEmailValidate(email)

            if (checkEmail) {
                val bundle = Bundle()
                bundle.putString("email", email)
                val fragment = ResetPassFragment()
                fragment.arguments = bundle
                findNavController().navigate(R.id.action_forgotPassFragment_to_resetPassFragment, bundle)
            }
            else if (TextUtils.isEmpty(email)) {
                Toast.makeText(requireContext(), "Please enter a valid email", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(), "User does not exist", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPassFragment_to_loginFragment)
        }
    }
}