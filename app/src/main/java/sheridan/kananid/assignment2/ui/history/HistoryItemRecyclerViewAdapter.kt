package sheridan.kananid.assignment2.ui.history

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sheridan.kananid.assignment2.R
import sheridan.kananid.assignment2.database.Envelope
import sheridan.kananid.assignment2.databinding.FragmentHistoryItemBinding
import androidx.navigation.findNavController


/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class HistoryItemRecyclerViewAdapter(
    private val values: Context
) : RecyclerView.Adapter<HistoryItemRecyclerViewAdapter.ViewHolder>() {

    var history: List<Envelope>? = null
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position + 1, history!![position])


    }

    override fun getItemCount(): Int = history?.size?:0

    class ViewHolder private constructor(
        private val binding: FragmentHistoryItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(count: Int, envelope: Envelope) {
            binding.count.text = binding.root.context.getString(R.string.count, count)
            binding.envelope = envelope

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FragmentHistoryItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}