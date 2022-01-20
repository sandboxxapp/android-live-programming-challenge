package com.sandboxx.swapi.transportation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sandboxx.swapi.R
import com.sandboxx.swapi.common.BaseRecyclerAdapter
import com.sandboxx.swapi.data.json.VehicleJson

class TransportationListAdapter: BaseRecyclerAdapter<VehicleJson>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TransportationItemVH(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vehicle = getItem(position) ?: return
        val vh = holder as TransportationItemVH
        vh.bind(vehicle)
    }

    class TransportationItemVH(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.row_item, parent, false)) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_name)
        private val modelTextView: TextView = itemView.findViewById(R.id.tv_model)
        private val capacityTextView: TextView = itemView.findViewById(R.id.tv_capacity)

        fun bind(vehicleJson: VehicleJson) {
            nameTextView.text = vehicleJson.name
            modelTextView.text = vehicleJson.model
            capacityTextView.text = vehicleJson.cargoCapacity
        }
    }
}