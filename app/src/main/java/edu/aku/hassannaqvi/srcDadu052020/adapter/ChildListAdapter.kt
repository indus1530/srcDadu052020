package edu.aku.hassannaqvi.srcDadu052020.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.aku.hassannaqvi.srcDadu052020.R
import edu.aku.hassannaqvi.srcDadu052020.contracts.ChildContract
import edu.aku.hassannaqvi.srcDadu052020.databinding.ItemChildListBinding
import edu.aku.hassannaqvi.srcDadu052020.utils.getMemberIcon
import edu.aku.hassannaqvi.srcDadu052020.viewmodel.MainVModel

class ChildListAdapter(private val mContext: Context, private var mList: List<ChildContract>, private val vModel: MainVModel) : RecyclerView.Adapter<ChildListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val bi: ItemChildListBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_child_list, viewGroup, false)
        return ViewHolder(bi)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.bi.parentLayout.tag = i
        holder.bi.name.text = mList[i].childName
        Glide.with(mContext)
                .asBitmap()
                .load(getMemberIcon(mList[i].getgender().toInt()))
                .into(holder.bi.childImage)
//        val age = mList[i].getagey().toInt().apply { this * 12 }.plus(mList[i].getagem().toInt())
/*        holder.bi.dob.text = StringBuilder().append("Age:").append(if (age < 0) "-" else age).append(" Month(s)")
        holder.bi.index.text = String.format("%02d", Integer.valueOf(mList[i].childSerial))
        holder.bi.motherName.text = StringBuilder("Mother Name:").append(mList[i].motherName)
        if (vModel.getCheckedItemValues(mList[i].serialno.toInt())) {
            holder.bi.checkIcon.visibility = View.VISIBLE
            holder.bi.parentLayout.isEnabled = false
        }*/

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setMList(members: List<ChildContract>) {
        mList = members
        notifyDataSetChanged()
    }

    class ViewHolder(val bi: ItemChildListBinding) : RecyclerView.ViewHolder(bi.root)

}