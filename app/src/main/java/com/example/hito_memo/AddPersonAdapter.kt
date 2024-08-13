package com.example.hito_memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hito_memo.databinding.AddPersonItemEditTextWithoutImageViewBinding
import com.example.hito_memo.databinding.AddPersonItemTextViewWithImageViewBinding
import com.example.hito_memo.databinding.AddPersonItemTextViewWithoutImageViewBinding

// 【町田さんからのアドバイス】
// AddPersonAdapter を修正して、textViewAddPerson の押下時に
// AddPersonItemXXXXBinding の EditText から文字列を取得できるようにする必要があります。

const val ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW = 0
const val ITEM_TEXT_VIEW_WITH_IMAGE_VIEW = 1
const val ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW = 2

class AddPersonAdapter(private val addPersonDataItemArrayList: List<AddPersonDataItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 「NewFolderFragment」のコードを参考にしてみる。
    inner class ItemTextViewWithoutImageViewHolder(private val binding: AddPersonItemTextViewWithoutImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {



        fun bindTextViewWithoutImageView(dataItem: AddPersonDataItem) {
            binding.profileTextView.text = dataItem.profileTextViewString

            UserEntity(nameOfUser = binding.profileEditText.setHint(dataItem.profileEditTextHint).toString())
            UserEntity(furiganaOfUser = binding.profileEditText.setHint(dataItem.profileEditTextHint).toString())
            UserEntity(nicknameOfUser = binding.profileEditText.setHint(dataItem.profileEditTextHint).toString())
            UserEntity(birthdayOfUser = binding.profileEditText.setHint(dataItem.profileEditTextHint).toString())
            UserEntity(originOfUser = binding.profileEditText.setHint(dataItem.profileEditTextHint).toString())
            UserEntity(addressOfUser = binding.profileEditText.setHint(dataItem.profileEditTextHint).toString())
            UserEntity(occupationOfUser = binding.profileEditText.setHint(dataItem.profileEditTextHint).toString())
            UserEntity(relationshipOfUser = binding.profileEditText.setHint(dataItem.profileEditTextHint).toString())
        }
    }

    inner class ItemTextViewWithImageViewHolder(private val binding: AddPersonItemTextViewWithImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTextViewWithImageView(dataItem: AddPersonDataItem) {
            binding.profile = dataItem
            binding.profileTextView.text = dataItem.profileTextViewString
            binding.profileEditText.setHint(dataItem.profileEditTextHint)
            dataItem.profileImageViewInt?.let { binding.profileImageView.setImageResource(it) }
        }
    }

    inner class ItemEditTextWithoutImageViewHolder(private val binding: AddPersonItemEditTextWithoutImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindEditTextWithoutImageView(dataItem: AddPersonDataItem) {
            binding.customProfileEditText.setHint(dataItem.profileCustomEditTextString)
            binding.profileEditText.setHint(dataItem.profileEditTextHint)
        }
    }

    override fun getItemViewType(position: Int): Int {

        return if (addPersonDataItemArrayList[position].profileImageViewInt != null) {
            ITEM_TEXT_VIEW_WITH_IMAGE_VIEW
        } else if (addPersonDataItemArrayList[position].profileTextViewString != null) {
            ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW
        } else {
            ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW) {
            val binding = AddPersonItemTextViewWithoutImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemTextViewWithoutImageViewHolder(binding)

        } else if (viewType == ITEM_TEXT_VIEW_WITH_IMAGE_VIEW){
            val binding = AddPersonItemTextViewWithImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemTextViewWithImageViewHolder(binding)

        } else {
            val binding = AddPersonItemEditTextWithoutImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemEditTextWithoutImageViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return addPersonDataItemArrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW) {

            (holder as ItemTextViewWithoutImageViewHolder).bindTextViewWithoutImageView(addPersonDataItemArrayList[position])

        } else if (getItemViewType(position) == ITEM_TEXT_VIEW_WITH_IMAGE_VIEW) {

            (holder as ItemTextViewWithImageViewHolder).bindTextViewWithImageView(addPersonDataItemArrayList[position])

        } else if (getItemViewType(position) == ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW) {

            (holder as ItemEditTextWithoutImageViewHolder).bindEditTextWithoutImageView(addPersonDataItemArrayList[position])

        }
    }
}