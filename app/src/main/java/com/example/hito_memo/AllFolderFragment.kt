package com.example.hito_memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hito_memo.databinding.FragmentAllFolderBinding

class AllFolderFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels {
        val userDao = UserAppDatabase.getUserAppDatabase(requireContext()).userDao()
        UserViewModelFactory(UserRepository(userDao))
    }

    private var _binding: FragmentAllFolderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllFolderBinding.inflate(inflater, container, false)

        viewModel.nameOfUser.observe(viewLifecycleOwner, Observer {
            binding.personNameFolderListView.adapter = PersonNameFolderAdapter(requireContext(), it.map { it.nameOfUser })
        })

        viewModel.furiganaOfUser.observe(viewLifecycleOwner, Observer {
            binding.personNameFolderListView.adapter = PersonNameFolderAdapter(requireContext(), it.map { it.furiganaOfUser })
        })

        viewModel.nicknameOfUser.observe(viewLifecycleOwner, Observer {
            binding.personNameFolderListView.adapter = PersonNameFolderAdapter(requireContext(), it.map { it.nicknameOfUser })
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.backToMainFragmentView.setOnClickListener {
            navController.navigate(R.id.action_allFolderFragment_to_mainFragment)
        }

        binding.searchEditText.setOnClickListener {

        }

        binding.navigateToFragmentAddPerson.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}