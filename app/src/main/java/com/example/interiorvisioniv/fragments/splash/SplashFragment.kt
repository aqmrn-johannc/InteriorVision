package com.example.interiorvisioniv.fragments.splash

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.interiorvisioniv.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//         Inflate the layout for this fragment
        Handler(Looper.getMainLooper()).postDelayed({

            if(onBoardingIsFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_accountOptionsFragment)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
            }

        },4000)

        val view =  inflater.inflate(R.layout.fragment_splash, container, false)

        val animTop = AnimationUtils.loadAnimation(view.context,R.anim.from_top)
        val animBottom = AnimationUtils.loadAnimation(view.context,R.anim.from_bottom)

        val ivlogo = view.findViewById<ImageView>(R.id.iv_logo)
        val tvcopyright = view.findViewById<TextView>(R.id.tv_copyright)

        ivlogo.animation = animTop
        tvcopyright.animation = animBottom

        return view
    }

    private fun onBoardingIsFinished(): Boolean{

        val sharedPreferences= requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("finished", false)
    }

}