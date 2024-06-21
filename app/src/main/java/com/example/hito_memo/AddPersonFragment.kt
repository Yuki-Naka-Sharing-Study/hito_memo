package com.example.hito_memo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.hito_memo.databinding.FragmentAddPersonBinding

class AddPersonFragment : Fragment() {

    private var _binding: FragmentAddPersonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.textViewCancelAddPerson.setOnClickListener {
            navController.navigate(R.id.action_addPersonFragment_to_mainFragment)
        }

        binding.textViewAddPerson.setOnClickListener {
            navController.navigate(R.id.action_addPersonFragment_to_mainFragment)
        }

        // GPTに聞いた感じではこの書き方が合っていそう
        binding.toggleButtonProfileAndMemo.addOnButtonCheckedListener { materialButtonToggleGroup, checkedId, isChecked ->
            Log.d(
                "machida",
                "onViewCreated() called with: , isChecked = $isChecked",
            )
            when (checkedId) {
                R.id.toggle_button_profile -> {
                    binding.scrollViewOfProfileAndMemo.isVisible = isChecked
                }
                R.id.toggle_button_memo -> {
                    binding.editTextMemoOfPerson.isVisible = isChecked
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}