//package com.example.hito_memo
//
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.hito_memo.databinding.BasicSettingItemImageViewWithEditTextBinding
//import com.example.hito_memo.databinding.BasicSettingItemTextViewWithToggleButtonBinding
//
//
//const val BASIC_SETTING_ITEM_TEXT_VIEW_WITH_TOGGLE_BUTTON = 0
//const val BASIC_SETTING_ITEM_IMAGE_VIEW_WITH_EDIT_TEXT = 1
//
//
//class BasicSettingAdapter(private val basicSettingList: List<BasicSettingDataItem>) :
//    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    inner class BasicSettingItemTextViewWIthToggleButtonViewHolder(private val binding: BasicSettingItemTextViewWithToggleButtonBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bindBasicSettingItemTextViewWithToggleButtonView(dataItem: BasicSettingDataItem) {
//            binding.basicSettingItemTextView.text = dataItem.basicSettingTextViewString
//            // ToggleButtonのbindはこの書き方で合っているか？
//            dataItem.basicSettingToggleButton.let { binding.basicSettingItemToggleButton }
//        }
//    }
//
//    inner class ItemBasicSettingImageViewWithEditTextViewHolder(private val binding: BasicSettingItemImageViewWithEditTextBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bindBasicSettingImageViewWithEditTextView(dataItem: BasicSettingDataItem) {
//            dataItem.profileImageViewInt?.let { binding.basicSettingItemImageView.setImageResource(it) }
//            binding.basicSettingItemEditText.setHint("アイコン変更")
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//
////        return if (mList[position].profileImageViewInt != null) {
////            ITEM_TEXT_VIEW_WITH_IMAGE_VIEW
////        } else {
////            ITEM_EDIT_TEXT_WITHOUT_IMAGE_VIEW
////        }
//
//        // return  if (basicSettingList[position])
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//
////        if (viewType == ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW) {
////            val binding = ItemTextViewWithoutImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
////            return ItemTextViewWithoutImageViewHolder(binding)
////        } else {
////            val binding = ItemEditTextWithoutImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
////            return ItemEditTextWithoutImageViewHolder(binding)
////        }
//
//
//
//    }
//
//    override fun getItemCount(): Int {
//        return basicSettingList.size
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//
////        if (getItemViewType(position) == ITEM_TEXT_VIEW_WITHOUT_IMAGE_VIEW) {
////
////            (holder as ItemTextViewWithoutImageViewHolder).bindTextViewWithoutImageView(mList[position])
////
////        } else {
////
////            (holder as ItemEditTextWithoutImageViewHolder).bindEditTextWithoutImageView(mList[position])
////
////        }
//
//
//
//
//    }
//}