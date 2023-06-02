package com.example.assignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment.db.Image
import com.example.assignment.db.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ImageViewModel : ViewModel() {

    private val imageRepository = ImageRepository()

    private val _imageList = MutableLiveData<List<Image>>()
    val imageList: LiveData<List<Image>>
        get() = _imageList

    fun fetchImages() {
        GlobalScope.launch(Dispatchers.IO) {
            val images = imageRepository.getImages()
            _imageList.postValue(images)
        }
    }
}