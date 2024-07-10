//package com.example.hito_memo
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//
//
//const val ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW = 0
//const val ITEM_TEXT_VIEW_WITH_IMAGE_VIEW = 1
//const val ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW = 2
//
//
//class BasicSettingAdapter(private val mList: List<BasicSettingDataItem>) :
//    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    inner class ItemTextViewWithoutImageViewHolder(private val binding: ItemTextViewWithoutImageViewBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bindTextViewWithoutImageView(dataItem: BasicSettingDataItem) {
//            binding.profileTextView.text = dataItem.profileTextViewString
//            binding.profileEditText.setHint(dataItem.profileEditTextString)
//        }
//    }
//
//    inner class ItemTextViewWithImageViewHolder(private val binding: ItemTextViewWithImageViewBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bindTextViewWithImageView(dataItem: BasicSettingDataItem) {
//            binding.profileTextView.text = dataItem.profileTextViewString
//            binding.profileEditText.setHint(dataItem.profileEditTextString)
//            dataItem.profileImageViewInt?.let { binding.profileImageView.setImageResource(it) }
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//
//        return if (mList[position].profileImageViewInt != null) {
//            ITEM_TEXT_VIEW_WITH_IMAGE_VIEW
//        } else if (mList[position].profileTextViewString != null) {
//            ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW
//        } else {
//            ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//
//        if (viewType == ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW) {
//            val binding = ItemTextViewWithoutImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//            return ItemTextViewWithoutImageViewHolder(binding)
//
//        } else if (viewType == ITEM_TEXT_VIEW_WITH_IMAGE_VIEW){
//            val binding = ItemTextViewWithImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//            return ItemTextViewWithImageViewHolder(binding)
//
//        } else {
//            val binding = ItemEditTextWithoutImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//            return ItemEditTextWithoutImageViewHolder(binding)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return mList.size
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//
//        if (getItemViewType(position) == ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW) {
//
//            (holder as ItemTextViewWithoutImageViewHolder).bindTextViewWithoutImageView(mList[position])
//
//        } else if (getItemViewType(position) == ITEM_TEXT_VIEW_WITH_IMAGE_VIEW) {
//
//            (holder as ItemTextViewWithImageViewHolder).bindTextViewWithImageView(mList[position])
//
//        } else if (getItemViewType(position) == ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW) {
//
//            (holder as ItemEditTextWithoutImageViewHolder).bindEditTextWithoutImageView(mList[position])
//
//        }
//    }
//}