package com.example.hito_memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hito_memo.databinding.FragmentProfileCustomizeFunctionBinding

class ProfileCustomizeFunctionFragment : Fragment() {

    private var _binding: FragmentProfileCustomizeFunctionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileCustomizeFunctionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

//        binding.profileCustomizeView.setOnClickListener {
//            navController.navigate(R.id.action_profileCustomizeFragment_to_profileCustomizeFunctionFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}