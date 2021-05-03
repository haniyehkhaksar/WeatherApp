package io.github.haniyehkhaksar.weatherapp.ui.news

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.haniyehkhaksar.weatherapp.databinding.ItemNewsBinding
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.NewsDomainModel

class NewsAdapter(private var items: MutableList<NewsDomainModel>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    fun updateData(newItems: List<NewsDomainModel>) {
        items.removeAll(items)
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsDomainModel) {
            binding.root.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                browserIntent.resolveActivity(binding.root.context.packageManager)?.let {
                    binding.root.context.startActivity(browserIntent)
                }
            }
            binding.info = item
            binding.executePendingBindings()
        }
    }
}