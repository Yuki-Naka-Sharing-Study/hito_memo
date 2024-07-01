package com.example.hito_memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
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

        val addPersonItems = listOf("名前", "フリガナ", "ニックネーム", "性別", "誕生日", "出身地", "住所", "職業", "関係", "電話番号", "Email", "X(旧 Twitter)", "Instagram", "Facebook")
        val addPersonAdapter = AddPersonAdapter(requireContext(), addPersonItems)
        binding.addPersonListView.adapter = addPersonAdapter

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

        binding.addImageOfPersonImageView.setOnClickListener {

        }

        // GPTに聞いた感じではこの書き方が合っていそう
        binding.toggleButtonProfileAndMemo.addOnButtonCheckedListener { materialButtonToggleGroup, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.toggle_button_profile -> {
                        binding.addPersonListView.isVisible = isChecked
                    }
                    R.id.toggle_button_memo -> {
                        binding.editTextMemoOfPerson.isVisible = isChecked
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}