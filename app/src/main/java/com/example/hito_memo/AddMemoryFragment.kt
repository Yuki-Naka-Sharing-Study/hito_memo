package com.example.hito_memo

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hito_memo.databinding.FragmentAddMemoryBinding

class AddMemoryFragment : Fragment() {

    private var _binding: FragmentAddMemoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddMemoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.closeAddMemoryViewButton.setOnClickListener {
            navController.navigate(R.id.action_addMemoryFragment_to_profileCustomizeFragment)
        }

        // 「絵文字を選択」「画像を選択」「カメラで撮影」「キャンセル」の四つを表示。
        binding.addMemoryView.setOnClickListener {

        }

        binding.addMemoryTimeView.setOnClickListener {

        }

        if (binding.addMemoryEditText.text.isNotBlank()) {
            binding.addMemoryTextViewTopRight.setTextColor(Color.parseColor("#4169E1"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}