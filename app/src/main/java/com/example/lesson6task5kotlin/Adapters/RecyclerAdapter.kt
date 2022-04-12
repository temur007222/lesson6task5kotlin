package com.example.lesson6task5kotlin.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson6task5kotlin.Model.User
import com.example.lesson6task5kotlin.R

class RecyclerAdapter(private var context: Context?, private var user: List<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_AVAILABLE_YES = 0
    private val TYPE_AVAILABLE_NO = 1

   fun RecyclerAdapter(context: Context?, users: List<User>?) {
        this.context = context
        if (users != null) {
            this.user = users
        }
    }


    override fun getItemCount(): Int {
        return user.size
    }

    override fun getItemViewType(position: Int): Int {
        val users: User = user[position]
        return if (users.isAvailable()) {
           return TYPE_AVAILABLE_YES
        } else {
            return TYPE_AVAILABLE_NO
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         if (viewType == TYPE_AVAILABLE_YES){
            val view: View = LayoutInflater.from(context).inflate(R.layout.item_user_list, viewGroup, false)
          return  RecyclerViewYESHolder(view)
        }else{
            val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_recycler_layout_not, viewGroup, false)
          return  RecyclerViewNOTHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val users: User = user[position]

        if (holder is RecyclerViewYESHolder) {
            val first_name = holder.first_name
            val last_name = holder.last_name
            first_name.text = users.getFirstName()
            last_name.text = users.getLastName()
        }

        if (holder is RecyclerViewNOTHolder) {
            val first_name = holder.first_name
            val last_name = holder.last_name
            first_name.text = "The first name is not available"
            last_name.text = "The second name is not available"
        }
    }

    class RecyclerViewYESHolder( view: View) : RecyclerView.ViewHolder(view) {
        var first_name: TextView = view.findViewById(R.id.first_name)
        var last_name: TextView = view.findViewById(R.id.last_name)

    }
    class RecyclerViewNOTHolder( view: View) : RecyclerView.ViewHolder(view) {
        var first_name: TextView = view.findViewById(R.id.first_name)
        var last_name: TextView = view.findViewById(R.id.last_name)

    }
}

