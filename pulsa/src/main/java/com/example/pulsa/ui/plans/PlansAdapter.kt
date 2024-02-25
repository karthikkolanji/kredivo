package com.example.pulsa.ui.plans

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pulsa.R
import com.example.pulsa.ui.plans.model.PlansItemResponseUiModel

class PlansAdapter(
    private val mList: List<PlansItemResponseUiModel>,
    private val onRechargeAction: (PlansItemResponseUiModel) -> Unit
) :
    RecyclerView.Adapter<PlansAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pulsa_plans, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plan = mList[position]
        holder.tvRechargeAmount.text = holder.tvRechargeAmount.context.resources.getString(
            R.string.recharge_amount,
            plan.rechargeAmount
        )
        holder.tvValidity.text = holder.tvRechargeAmount.context.resources.getString(
            R.string.validity_unlimited,
        )
        holder.tvTalkTime.text = holder.tvRechargeAmount.context.resources.getString(
            R.string.recharge_amount,
            plan.talkTimeAmount
        )
        holder.tvProductName.text = plan.productName
        holder.btnRecharge.setOnClickListener { onRechargeAction(plan) }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRechargeAmount: TextView = itemView.findViewById(R.id.tv_recharge_amount)
        val tvValidity: TextView = itemView.findViewById(R.id.tv_validity)
        val tvTalkTime: TextView = itemView.findViewById(R.id.tv_talk_time)
        val tvProductName: TextView = itemView.findViewById(R.id.tv_product_name)
        val btnRecharge: TextView = itemView.findViewById(R.id.btn_recharge)
    }
}

fun Context.getString() {

}
