package com.rogue.mvvmsample.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogue.mvvmsample.R
import com.rogue.mvvmsample.data.User
import kotlinx.android.synthetic.main.layout_user_row.view.*

class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_user_row, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.user_name.text = users[position].name
        holder.itemView.email_id.text = users[position].email
        holder.itemView.phone_num.text = users[position].phone
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}