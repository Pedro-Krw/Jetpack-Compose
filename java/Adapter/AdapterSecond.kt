package com.pedro.fragmentapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.fragmentapplication.Model.dataModelSecond
import com.pedro.fragmentapplication.R
import com.squareup.picasso.Picasso

class AdapterSecond (private val list : ArrayList<dataModelSecond>) : RecyclerView.Adapter<AdapterSecond.SecondViewHolder>(){
   inner class SecondViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

       fun bind(dataModelSecond: dataModelSecond){
           with(itemView){

               val judul : TextView = findViewById(R.id.judul)
               val tanggal : TextView = findViewById(R.id.tanggal)
               val deskripsi : TextView = findViewById(R.id.deskripsi)
               val image : ImageView = findViewById(R.id.thumb)

               judul.text = "${dataModelSecond.title}"
               deskripsi.text = "${dataModelSecond.description}"
               tanggal.text = "${dataModelSecond.publishedAt}"

               Picasso.get()
                   .load(dataModelSecond.urlToImage)
                   .resize(650, 366)
                   .centerCrop()
                   .into(image)



           }
       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_second_fragment, parent , false)

        return SecondViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}