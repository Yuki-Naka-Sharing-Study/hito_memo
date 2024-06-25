package com.example.hito_memo

// SecurityAdapter.kt
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView


class SecurityAdapter(private val context: Context, private val dataSource: List<String>) : BaseAdapter() {

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
        val securityRowView = convertView ?: inflater.inflate(R.layout.security_list_item, parent, false)

        val securityItemTextView = securityRowView.findViewById(R.id.security_item_text_view) as TextView
        val securityItemImageButton = securityRowView.findViewById(R.id.security_item_image_button) as ImageButton

        val securityItem = getItem(position) as String
        securityItemTextView.text = securityItem

        securityItemImageButton.setOnClickListener {
            // ボタンがクリックされたときの動作をここに追加
        }

        return securityRowView
    }
}