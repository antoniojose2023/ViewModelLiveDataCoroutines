package br.com.antoniojoseuchoa.viewmodellivedatacoroutines.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.databinding.ItemUrlBinding
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain.EncurtedUrl

class AdapterUrl: ListAdapter<EncurtedUrl, AdapterUrl.ViewHolderUrl>(DiffCalback()){

    class ViewHolderUrl(private val binding: ItemUrlBinding): ViewHolder(binding.root){
            fun bind(item: EncurtedUrl){
                 binding.run {
                     tvOrigin.text = item.urlOrigin
                     tvEncurtedUrl.text = item.urlEncurted
                 }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUrl {
        val inflater = LayoutInflater.from( parent.context )
        val binding = ItemUrlBinding.inflate( inflater, parent, false)
        return ViewHolderUrl(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderUrl, position: Int) {
           val item = getItem(position)
           holder.bind(item)
    }

    class DiffCalback: DiffUtil.ItemCallback<EncurtedUrl>(){
        override fun areItemsTheSame(oldItem: EncurtedUrl, newItem: EncurtedUrl): Boolean {
            return oldItem.urlOrigin == newItem.urlOrigin
        }

        override fun areContentsTheSame(oldItem: EncurtedUrl, newItem: EncurtedUrl): Boolean {
            return oldItem == newItem
        }
    }

}