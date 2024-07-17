package com.example.hito_memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hito_memo.databinding.FragmentNewFolderBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        // りくとさんから習った空文字判定をしないといけない。
        binding.textViewCompleteNewFolder.setOnClickListener {
            if (binding.editTextAddNewFolder.text.toString() == "") {

                    NewFolderDialog.Builder(this)
                        .setTitle("別の名前を選択してください。")
                        .setMessage("フォルダ名は空白にできません。")
                        .setPositiveButton("OK")
                        .build()
                        .show(childFragmentManager, NewFolderDialog::class.simpleName)

            } else {

                val mainActivity = activity as MainActivity?
                if (mainActivity != null) {

                    lifecycleScope.launch(Dispatchers.IO) {
                        withContext(Dispatchers.Default) {
                            mainActivity.userDao.insertUser(
                                UserEntity(nameOfUserFolder = binding.editTextAddNewFolder.text.toString())
                            )
                        }
                    }

                }

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