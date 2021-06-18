package com.dicoding.movieapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.movieapp.core.R
import com.dicoding.movieapp.core.data.source.local.entity.MovieEntity
import com.dicoding.movieapp.core.databinding.ItemListMovieBinding
import com.dicoding.movieapp.core.domain.model.Movie


import java.util.ArrayList

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        fun bind(movie: Movie) {
            with(binding) {
                when(movie.photo){
                    1-> movie.photo = R.drawable.poster_a_start_is_born
                    2->movie.photo = R.drawable.poster_alita
                    3->movie.photo = R.drawable.poster_aquaman
                    4->movie.photo = R.drawable.poster_bohemian
                    5->movie.photo = R.drawable.poster_cold_persuit
                    6->movie.photo = R.drawable.poster_creed
                    7->movie.photo = R.drawable.poster_crimes
                    8->movie.photo = R.drawable.poster_glass
                    9->movie.photo = R.drawable.poster_how_to_train
                    10->movie.photo = R.drawable.poster_infinity_war
                    else-> {
                        movie.photo = movie.photo
                    }
                }

                Glide.with(itemView.context)
                    .load(movie.photo)
                    .into(ivItemImage)
                tvItemTitle.text = movie.name
                tvItemSubtitle.text = movie.description
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}