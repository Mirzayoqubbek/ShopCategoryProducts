package com.example.topshiriq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topshiriq.view.CategoryAdapter
import com.example.topshiriq.view.PostAdapter
import com.example.topshiriq.api.Api
import com.example.topshiriq.databinding.ActivityMainBinding
import com.example.topshiriq.model.CategoryModel
import com.example.topshiriq.view.CategoryAdapterCallback

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel = MainViewModel()

        viewModel.postData.observe(this, Observer {
            if (it != null) {
                viewModel.insertAllPost2DB(it)
            }
        })

        viewModel.categoryData.observe(this, Observer {
            if (it != null) {
                viewModel.insertAllCategory2DB(it)
            }
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        viewModel.categoryData.observe(this, Observer {
            binding.categoryRecycler.adapter =
                CategoryAdapter(it, object : CategoryAdapterCallback {
                    override fun onClinkItem(item: CategoryModel) {
                        viewModel.getCategoryByPost(item.id)
                    }
                })
        })

        viewModel.postData.observe(this, Observer {
            binding.postRecycler.adapter = PostAdapter(it)
        })

        binding.categoryRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.postRecycler.layoutManager = LinearLayoutManager(this)

        loadData()
    }

    fun loadData() {
        viewModel.getAllDBCategory()
//        viewModel.gerCategory()
        viewModel.getAllDBPost()
//        viewModel.getPost()
    }
}