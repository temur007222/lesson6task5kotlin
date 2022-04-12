package com.example.lesson6task5kotlin.Activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson6task5kotlin.Adapters.RecyclerAdapter
import com.example.lesson6task5kotlin.Model.User
import com.example.lesson6task5kotlin.R
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        val users = prepareUserList()
        refreshAdapter(users)
    }

    private fun initView() {

        context = this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
    }

    private fun refreshAdapter(users: List<User>) {

        val adapter = RecyclerAdapter(context, users)
        recyclerView!!.adapter = adapter
    }

    private fun prepareUserList(): List<User> {

        val users: MutableList<User> = ArrayList()

        for (i in 0..19) {
            if (i == 0 || i == 5 || i == 10 || i == 15 || i == 20) {
                users.add(User("Nick$i", "Johnson", false))
            } else {
                users.add(User("Nick$i", "Johnson", true))
            }
        }
        return users
    }
}