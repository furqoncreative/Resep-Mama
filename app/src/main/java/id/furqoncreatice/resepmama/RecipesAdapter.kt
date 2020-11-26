package id.furqoncreatice.resepmama

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.furqoncreatice.resepmama.databinding.ItemRowRecipesBinding

class RecipesAdapter(private val listener: onItemClickListener) :
    RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    val items = ArrayList<Recipe>()

    fun setItems(items: ArrayList<Recipe>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    interface onItemClickListener {
        fun onClick(id: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRowRecipesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindView(items[position])

    override fun getItemCount() = items.size

    class ViewHolder(
        private val itemBinding: ItemRowRecipesBinding,
        private val listener: onItemClickListener
    ) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {
        private lateinit var item: Recipe

        init {
            itemBinding.root.setOnClickListener(this)
        }

        fun bindView(item: Recipe) {
            this.item = item
            itemBinding.title.text = item.title
            Glide.with(itemBinding.root).load(item.image).into(itemBinding.thumbnail)
        }

        override fun onClick(v: View?) {
            listener.onClick(item.id)
        }

    }
}