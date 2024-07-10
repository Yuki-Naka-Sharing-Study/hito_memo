package com.example.hito_memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hito_memo.databinding.AddPersonItemEditTextWithoutImageViewBinding
import com.example.hito_memo.databinding.AddPersonItemTextViewWithImageViewBinding
import com.example.hito_memo.databinding.AddPersonItemTextViewWithoutImageViewBinding

const val ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW = 0
const val ITEM_TEXT_VIEW_WITH_IMAGE_VIEW = 1
const val ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW = 2

class AddPersonAdapter(private val mList: List<AddPersonDataItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemTextViewWithoutImageViewHolder(private val binding: AddPersonItemTextViewWithoutImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTextViewWithoutImageView(dataItem: AddPersonDataItem) {
            binding.profileTextView.text = dataItem.profileTextViewString
            binding.profileEditText.setHint(dataItem.profileEditTextString)
        }
    }

    inner class ItemTextViewWithImageViewHolder(private val binding: AddPersonItemTextViewWithImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTextViewWithImageView(dataItem: AddPersonDataItem) {
            binding.profileTextView.text = dataItem.profileTextViewString
            binding.profileEditText.setHint(dataItem.profileEditTextString)
            dataItem.profileImageViewInt?.let { binding.profileImageView.setImageResource(it) }
        }
    }

    inner class ItemEditTextWithoutImageViewHolder(private val binding: AddPersonItemEditTextWithoutImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindEditTextWithoutImageView(dataItem: AddPersonDataItem) {
            binding.customProfileEditText.setHint(dataItem.profileCustomEditTextString)
            binding.profileEditText.setHint(dataItem.profileEditTextString)
        }
    }

    override fun getItemViewType(position: Int): Int {

        return if (mList[position].profileImageViewInt != null) {
            ITEM_TEXT_VIEW_WITH_IMAGE_VIEW
        } else if (mList[position].profileTextViewString != null) {
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
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW) {

            (holder as ItemTextViewWithoutImageViewHolder).bindTextViewWithoutImageView(mList[position])

        } else if (getItemViewType(position) == ITEM_TEXT_VIEW_WITH_IMAGE_VIEW) {

            (holder as ItemTextViewWithImageViewHolder).bindTextViewWithImageView(mList[position])

        } else if (getItemViewType(position) == ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW) {

            (holder as ItemEditTextWithoutImageViewHolder).bindEditTextWithoutImageView(mList[position])

        }
    }
}