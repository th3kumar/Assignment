package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.adapter.ImageAdapter
import com.example.assignment.viewModel.ImageViewModel

class ImageListActivity : AppCompatActivity() {

    private lateinit var imageRecyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_list)

        imageRecyclerView = findViewById(R.id.imageRecyclerView)
        imageRecyclerView.layoutManager = LinearLayoutManager(this)

        imageAdapter = ImageAdapter()
        imageRecyclerView.adapter = imageAdapter

        imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)
        imageViewModel.imageList.observe(this, { images ->
            imageAdapter.setImageList(images)
        })

        imageViewModel.fetchImages()
    }
}
