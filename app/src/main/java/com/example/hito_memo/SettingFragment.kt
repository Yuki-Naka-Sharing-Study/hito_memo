package com.example.hito_memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hito_memo.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)

        // セキュリティ
        val securityItems = listOf("パスコード認証", "生体認証")
        val securityAdapter = SecurityAdapter(requireContext(), securityItems)
        binding.securityListView.adapter = securityAdapter

        // 基本設定


        // 通知設定


        // 機種変更
        val modelChangeItems = listOf("機種変更コード発行","機種変更コード入力して復元")
        val modelChangeAdapter = ModelChangeAdapter(requireContext(), modelChangeItems)
        binding.modelChangeListView.adapter = modelChangeAdapter

        // このアプリに付いて


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.closeSettingViewButton.setOnClickListener {
            navController.navigate(R.id.action_settingFragment_to_mainFragment)
        }

        binding.hitoMemoProView.setOnClickListener {
            navController.navigate(R.id.action_settingFragment_to_hitoMemoFragment)
        }

        //　以下のコードは一旦仮で作成。おそらく間違っている。
//        binding.modelChangeListView.setOnClickListener {
//            navController.navigate(R.id.action_settingFragment_to_modelChangeCodeIssueFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}