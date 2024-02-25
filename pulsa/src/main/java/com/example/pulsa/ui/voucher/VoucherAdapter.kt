package com.example.pulsa.ui.voucher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pulsa.R
import com.example.pulsa.ui.voucher.model.VoucherItemUiModel

class VoucherAdapter(
    private val mList: List<VoucherItemUiModel>,
    private val onVoucherUseAction: (VoucherItemUiModel) -> Unit
) :
    RecyclerView.Adapter<VoucherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_voucher, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val voucher = mList[position]
        holder.tvPercentage.text = voucher.percentage.toString()
        holder.tvCondition.text = voucher.maxDiscount
        holder.tvValidity.text = voucher.endDate
        holder.btnUse.setOnClickListener { onVoucherUseAction(voucher) }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPercentage: TextView = itemView.findViewById(R.id.tv_voucher_percentage)
        val tvCondition: TextView = itemView.findViewById(R.id.tv_voucher_condition)
        val tvValidity: TextView = itemView.findViewById(R.id.tv_voucher_validity)
        val btnUse: TextView = itemView.findViewById(R.id.btn_use_voucher)
    }
}
