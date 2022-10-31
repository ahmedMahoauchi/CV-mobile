package com.example.cvv2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cvv2.R
import com.example.cvv2.dataCalss.Experience
import com.suis.sqlite.SQLiteHelper

class ExperienceAdapter(val experiences:ArrayList<Experience>, val context: Context? ) : RecyclerView.Adapter<ExperienceAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var companyName: TextView = itemView.findViewById(R.id.company_name)
        var companyAdress: TextView = itemView.findViewById(R.id.company_adress)
        var relativeLayout: RelativeLayout = itemView.findViewById(R.id.relativeLayout)
        var startDate: TextView = itemView.findViewById(R.id.start_date)
        var endDate: TextView = itemView.findViewById(R.id.end_date)
        var description: TextView = itemView.findViewById(R.id.campany_description)
        var delete: ImageView = itemView.findViewById(R.id.delete)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view:View= LayoutInflater.from(parent.context).inflate(R.layout.experience_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.companyName.text=experiences[position].name
        holder.companyAdress.text=experiences[position].adress
        holder.startDate.text=experiences[position].startDate
        holder.endDate.text=experiences[position].endDate
        holder.description.text= experiences[position].description
        holder.relativeLayout.setBackgroundResource(experiences[position].img)
        holder.delete.setOnClickListener{
            removeAt(position)
        }

    }

    override fun getItemCount(): Int {
        return experiences.size
    }
    private lateinit var sqLiteHelper: SQLiteHelper
    fun removeAt(position: Int){
        val sqLiteHelper = SQLiteHelper(context)
        val isDelete = sqLiteHelper.deleteExperience(experiences[position])
        if(isDelete>0){
            experiences.removeAt(position)
            notifyItemRemoved(position)
        }
    }



}