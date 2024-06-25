package com.example.hito_memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView


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
        val modelChangeRowView = convertView ?: inflater.inflate(R.layout.model_change_list_item, parent, false)

        val modelChangeItemTextView = modelChangeRowView.findViewById(R.id.model_change_item_text_view) as TextView
        val modelChangeItemImageButton = modelChangeRowView.findViewById(R.id.model_change_item_image_button) as ImageButton

        val modelChangeItem = getItem(position) as String
        modelChangeItemTextView.text = modelChangeItem

        modelChangeItemImageButton.setOnClickListener {
            // ボタンがクリックされたときの動作をここに追加
        }

        return modelChangeRowView
    }
}