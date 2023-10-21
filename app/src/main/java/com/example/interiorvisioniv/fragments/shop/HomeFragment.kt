package com.example.interiorvisioniv.fragments.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R
import com.example.interiorvisioniv.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            casaitaliana.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_casaItalianaFragment)
            }
        }

        binding.apply {
            modelmisello.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_modelMiselloFragment)
            }
        }

        binding.apply {
            dolcevita.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_dolceVitaFragment)
            }
        }

        binding.apply {
            romarustico.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_romaRusticoFragment)
            }
        }

        binding.apply {
            tvshopnow.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_modelMiselloFragment)
            }
        }

        binding.apply {
            tvshopnow2.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_dolceVitaFragment)
            }
        }

    }
}