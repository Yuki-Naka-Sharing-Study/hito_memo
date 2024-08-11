package com.example.hito_memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.example.hito_memo.databinding.SecurityListItemBinding

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
        val binding: SecurityListItemBinding
        val view: View

        if (convertView == null) {
            binding = SecurityListItemBinding.inflate(inflater, parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = convertView.tag as SecurityListItemBinding
            view = convertView
        }

        val securityItem = getItem(position) as String
        binding.securityItemTextView.text = securityItem
        val switchCompat = binding.securityItemToggleButton
        switchCompat.thumbTintList = ContextCompat.getColorStateList(context, R.color.switchOffColor)

        switchCompat.setOnCheckedChangeListener { _, isChecked ->
            val colorRes = if (isChecked) R.color.switchOnColor else R.color.switchOffColor
            switchCompat.thumbTintList = ContextCompat.getColorStateList(context, colorRes)
        }

        binding.securityItemToggleButton.setOnClickListener {
            // ボタンがクリックされたときの動作をここに追加
        }

        return view
    }
}