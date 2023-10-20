package com.example.interiorvisioniv.fragments.loginregister

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.databinding.FragmentForgotPasswordBinding
import com.example.interiorvisioniv.databinding.FragmentResetPassBinding
import com.example.interiorvisioniv.helper.DBHelper

class ResetPassFragment : Fragment() {
    private lateinit var binding: FragmentResetPassBinding

    private lateinit var enterPass: EditText
    private lateinit var reEnterPass: EditText
    private lateinit var db: DBHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResetPassBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = this.arguments
        val inputData = args?.getString("email", "")
        binding.tvName.text = inputData.toString()

        enterPass = binding.etPassword
        reEnterPass = binding.etReEnterPassword
        db = DBHelper(requireContext())
        val userEmail = binding.tvName.text.toString()

        binding.btnConfirm.setOnClickListener {
            val password = enterPass.text.toString()
            val reEnterPass = reEnterPass.text.toString()
            val checkEmail = db.checkEmailValidate(userEmail)

            if (password == reEnterPass) {
                if (checkEmail) {
                    db.updatePass(userEmail, password)
                    Toast.makeText(requireContext(), "Password Updated", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_resetPassFragment_to_loginFragment)
                }
                else {
                    Toast.makeText(requireContext(), "User does not exist", Toast.LENGTH_SHORT).show()
                }
            }
            else if (TextUtils.isEmpty(password) || TextUtils.isEmpty(reEnterPass)) {
                Toast.makeText(requireContext(), "Field/s cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(), "Password does not match", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_resetPassFragment_to_forgotPassFragment)
        }

    }
}
