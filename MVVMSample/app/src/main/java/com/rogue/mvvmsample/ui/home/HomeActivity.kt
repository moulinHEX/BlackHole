package com.rogue.mvvmsample.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.rogue.mvvmsample.MyApplication
import com.rogue.mvvmsample.R
import com.rogue.mvvmsample.data.User
import com.rogue.mvvmsample.data.UserRepository
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(
            this
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.get_button) {
            getUsers(v)
        }
    }

    private fun getUsers(button: View) {
        button.isEnabled = false
        progress.visibility = View.VISIBLE
        viewModel.getUsers().observe(this, Observer {
            progress.visibility = View.GONE
            button.isEnabled = true
            it?.let {
                prepareRecyclerView(it)
                button.visibility = View.GONE
            } ?: kotlin.run {
                Snackbar.make(button, "Error occurred while getting users", Snackbar.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun prepareRecyclerView(users: List<User>) {
        val layoutManager = LinearLayoutManager(this)
        users_list.layoutManager = layoutManager
        users_list.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        users_list.adapter = UserAdapter(users)
    }
}
