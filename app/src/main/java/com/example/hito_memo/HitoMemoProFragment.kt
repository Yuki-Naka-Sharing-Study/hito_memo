package com.example.hito_memo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hito_memo.databinding.FragmentHitoMemoProBinding

class HitoMemoProFragment : Fragment() {

    private var _binding: FragmentHitoMemoProBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHitoMemoProBinding.inflate(inflater, container, false)

        // セキュリティ
        val hitoMemoProItems = listOf("アプリ内の全広告", "アプリアイコン変更", "3日前、7日前に誕生日通知可能", "プロフィールカスタマイズ機能")
        val hitoMemoProAdapter = HitoMemoProAdapter(requireContext(), hitoMemoProItems)
        binding.hitoMemoProListView.adapter = hitoMemoProAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.backToSettingViewImageButton.setOnClickListener {
            navController.navigate(R.id.action_hitoMemoProFragment_to_settingFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}