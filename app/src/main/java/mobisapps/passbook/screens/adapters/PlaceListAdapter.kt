package mobisapps.passbook.screens.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import mobisapps.passbook.R
import mobisapps.passbook.entities.PlaceEntity

class PlaceListAdapter(val items: List<PlaceEntity>, val listener: PlaceListListener) : RecyclerView.Adapter<PlaceListAdapter.Holder>() {

    interface PlaceListListener {
        fun onItemClicked(place: PlaceEntity)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Holder(parent: ViewGroup, private val listener: PlaceListListener) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.place_list_adapter_item, parent, false)) {
        fun bind(place: PlaceEntity) {
            val titleView = itemView.findViewById(R.id.place_list_adapter_item_title) as TextView
            titleView.text = place.name
            titleView.setOnClickListener { listener.onItemClicked(place) }
        }
    }
}