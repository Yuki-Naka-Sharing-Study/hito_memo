package com.example.hito_memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hito_memo.databinding.FragmentAddPersonBinding

class AddPersonFragment : Fragment() {

    private var _binding: FragmentAddPersonBinding? = null
    private val binding get() = _binding!!
    private lateinit var mList: ArrayList<AddPersonDataItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPersonBinding.inflate(inflater, container, false)

        binding.addPersonRecyclerView.setHasFixedSize(true)
        binding.addPersonRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val itemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.addPersonRecyclerView.addItemDecoration(itemDecoration)

        mList = ArrayList()
        prepareData()

        val adapter = AddPersonAdapter(mList)
        binding.addPersonRecyclerView.adapter = adapter

        return binding.root
    }

    private fun prepareData() {

        mList.add(
            AddPersonDataItem(
                "名前",
                "田中太郎",
                null,
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                "フリガナ",
                "タナカタロウ",
                null,
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                "ニックネーム",
                "たろちゃん",
                null,
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                "性別",
                "未選択",
                null,
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                "誕生日",
                "2000年1月1日",
                null,
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                "出身地",
                "秋田県",
                null,
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                "住所",
                "東京都",
                null,
                R.drawable.address
            )
        )

        mList.add(
            AddPersonDataItem(
                "職業",
                "エンジニア",
                null,
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                "関係",
                "会社の同僚",
                null,
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                "電話番号",
                "080-1234-1234",
                null,
                R.drawable.link
            )
        )

        mList.add(
            AddPersonDataItem(
                "Email",
                "taro@example.com",
                null,
                R.drawable.link
            )
        )

        mList.add(
            AddPersonDataItem(
                "X(旧Twitter)",
                "@tanakataro",
                null,
                R.drawable.link
            )
        )

        mList.add(
            AddPersonDataItem(
                "Instagram",
                "@tanakataro",
                null,
                R.drawable.link
            )
        )

        mList.add(
            AddPersonDataItem(
                "Facebook",
                "@tanakataro",
                null,
                R.drawable.link
            )
        )

        mList.add(
            AddPersonDataItem(
                null,
                "内容",
                "カスタム1",
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                null,
                "内容",
                "カスタム2",
                null
            )
        )

        mList.add(
            AddPersonDataItem(
                null,
                "内容",
                "カスタム3",
                null,
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.textViewCancelAddPerson.setOnClickListener {
            navController.navigate(R.id.action_addPersonFragment_to_mainFragment)
        }

        binding.textViewAddPerson.setOnClickListener {

            if (binding.editTextMemoOfPerson.text.toString() == "") {

                AddPersonDialog.Builder(this)
                    .setTitle("入力エラー")
                    .setMessage("名前、フリガナ、またはニックネームの\n少なくとも一つを入力してください。")
                    .setPositiveButton("OK")
                    .build()
                    .show(childFragmentManager, AddPersonDialog::class.simpleName)

            } else {



                navController.navigate(R.id.action_addPersonFragment_to_mainFragment)
            }

        }

        binding.addImageOfPersonImageView.setOnClickListener {

        }

        // GPTに聞いた感じではこの書き方が合っていそう
        binding.toggleButtonProfileAndMemo.addOnButtonCheckedListener { materialButtonToggleGroup, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.toggle_button_profile -> {
                        binding.addPersonRecyclerView.isVisible = isChecked
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