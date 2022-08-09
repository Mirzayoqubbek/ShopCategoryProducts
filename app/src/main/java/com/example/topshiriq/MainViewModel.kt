package com.example.topshiriq

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.topshiriq.api.Repasitory
import com.example.topshiriq.db.AppDatabase
import com.example.topshiriq.model.CategoryModel
import com.example.topshiriq.model.PostModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val error = MutableLiveData<String>()
    val categoryData = MutableLiveData<List<CategoryModel>>()
    val postData = MutableLiveData<List<PostModel>>()
    val repository = Repasitory()

    fun gerCategory() {
        repository.getCategoriy(error, categoryData)
    }

    fun getPost() {
        repository.getPost(error, postData)
    }

    fun getCategoryByPost(id: Int) {
        repository.getPostById(id, error, postData)
    }

    fun insertAllPost2DB(items: List<PostModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            AppDatabase.getDatabase().getPostDao().insertAll(items)
            CoroutineScope(Dispatchers.Main).launch {
                error.value = "Malumotlar bazaga saqlandi!"
            }
        }
    }

    fun insertAllCategory2DB(items: List<CategoryModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            AppDatabase.getDatabase().getCategoryDao().insertAll(items)
        }
    }

    fun getAllDBPost() {
        CoroutineScope(Dispatchers.Main).launch {
            postData.value =
                withContext(Dispatchers.IO) { AppDatabase.getDatabase().getPostDao().getAllPost() }
        }

    }

    fun getAllDBCategory() {
        CoroutineScope(Dispatchers.Main).launch {
            categoryData.value =
                withContext(Dispatchers.IO) {
                    AppDatabase.getDatabase().getCategoryDao().getAllCategories()
                }
        }
    }

}