package com.example.hito_memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hito_memo.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels {
        val userDao = UserAppDatabase.getUserAppDatabase(requireContext()).userDao()
        UserViewModelFactory(UserRepository(userDao))
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel.nameOfUserFolder.observe(viewLifecycleOwner, Observer {
            binding.createdFolder.adapter = CreatedFolderAdapter(requireContext(), it.map { it.nameOfUserFolder })
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.settingButton.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_settingFragment)
        }

        binding.allFolderView.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_allFolderFragment)
        }

        binding.editFoldersTextView.setOnClickListener {
            // 作成済みフォルダの編集
            if (binding.editFoldersTextView.text.equals("編集")) {
                binding.editFoldersTextView.setText("完了")
            } else {
                binding.editFoldersTextView.text = "編集"
            }
        }

        binding.newFolderButton.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_newFolderFragment)
        }

        binding.addPersonButton.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_addPersonFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}