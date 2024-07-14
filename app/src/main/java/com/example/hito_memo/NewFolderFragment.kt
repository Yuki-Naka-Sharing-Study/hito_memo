package com.example.hito_memo

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
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

        binding.textViewCompleteNewFolder.setOnClickListener {
            if (binding.editTextAddNewFolder.text.toString() == "") {

                val customView = layoutInflater.inflate(R.layout.custom_alert_dialog, null)
                val dialog = AlertDialog.Builder(requireContext(), R.style.CustomAlertDialog)
                    .setView(customView)
                    .create()

                customView.findViewById<Button>(R.id.alertPositiveButton).setOnClickListener {
                    dialog.dismiss()
                }

                dialog.show()

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