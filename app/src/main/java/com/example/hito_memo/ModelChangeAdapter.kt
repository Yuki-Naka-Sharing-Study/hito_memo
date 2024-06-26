package com.example.hito_memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.hito_memo.databinding.ModelChangeListItemBinding

class ModelChangeAdapter(private val context: Context, private val dataSource: List<String>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ModelChangeListItemBinding
        val view: View

        if (convertView == null) {
            binding = ModelChangeListItemBinding.inflate(inflater, parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = convertView.tag as ModelChangeListItemBinding
            view = convertView
        }

        val modelChangeItem = getItem(position) as String
        binding.modelChangeItemTextView.text = modelChangeItem

        binding.modelChangeItemImageButton.setOnClickListener {
            // ボタンがクリックされたときの動作をここに追加
        }

        return view
    }
}