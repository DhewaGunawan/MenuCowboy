package com.catnip.cowboyshoot.ui.onboarding.entername

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.catnip.cowboyshoot.databinding.FragmentEnterNameBinding
import com.catnip.cowboyshoot.ui.menu.MenuActivity
import com.catnip.cowboyshoot.ui.onboarding.OnFinishNavigateListener
import com.catnip.cowboyshoot.ui.onboarding.OnboardingActivity


class EnterNameFragment : Fragment(), OnFinishNavigateListener {

    private lateinit var binding: FragmentEnterNameBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEnterNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onFinishNavigateListener() {
        val name = binding.etName.text.toString().trim()
        if (name.isEmpty()) {
            Toast.makeText(requireContext(), "Please input your name !", Toast.LENGTH_SHORT).show()
        } else {
            navigateToMenu(name)
        }
    }

    private fun navigateToMenu(name: String) {
//        Toast.makeText(requireContext(), "Name : $name", Toast.LENGTH_SHORT).show()
        val intent = Intent(requireContext(), MenuActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra("name", name)
        startActivity(intent)
    }
}

