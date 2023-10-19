package com.example.interiorvisioniv.fragments.shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgLogOut.setOnClickListener{
//            val intent = Intent(context, LoginRegisterActivity::class.java)
//            intent.putExtra("fragment_login", "displayLoginPage")
//
//            startActivity(intent)
        }
    }
}