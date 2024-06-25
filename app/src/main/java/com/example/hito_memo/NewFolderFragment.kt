package com.example.hito_memo

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hito_memo.databinding.FragmentNewFolderBinding

class NewFolderFragment : Fragment() {

    private var _binding: FragmentNewFolderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewFolderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.textViewCancelNewFolder.setOnClickListener {
            navController.navigate(R.id.action_newFolderFragment_to_mainFragment)
        }

        // 「cancelNewFolderButton」をタップして文字列を削除した状態で
        // 「textViewCompleteNewFolder」をタップしても「AlertDialog」が表示されない。
        binding.textViewCompleteNewFolder.setOnClickListener {
            if (binding.editTextAddNewFolder.text.equals("")) {
                AlertDialog.Builder(requireContext())
                    .setTitle("別の名前を選択してください。")
                    .setMessage("フォルダ名は空白にできません。")
                    .setPositiveButton("OK", { dialog, which ->
                        // TODO:Yesが押された時の挙動

                    })
                    .show()
            } else {
                navController.navigate(R.id.action_newFolderFragment_to_mainFragment)
            }
        }

        binding.cancelNewFolderButton.setOnClickListener {
            binding.editTextAddNewFolder.setText("")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}