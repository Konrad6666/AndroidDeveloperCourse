package com.example.lessonplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonplan.adapter.MyAdapter
import com.example.lessonplan.model.Post
import com.example.lessonplan.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        print("halo")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        newRecyclerView = findViewById(R.id.myRec)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)


        val newList = arrayListOf<Post>()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val options : HashMap<String, String> = HashMap()

        options["_sort"] = "id"
        options["_order"] = "desc"

        viewModel.getGivenPosts(2, options)
        viewModel.myGivenPosts.observe(this, Observer{response ->
            if (response.isSuccessful){
                response.body()?.forEach{
                    newList.add(Post(it.userId, it.id, it.title, it.body))
                }
                newRecyclerView.adapter = MyAdapter(newList)
            }
            else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }

        })
    }
}