package com.example.lessonplan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lessonplan.model.Post
import com.example.lessonplan.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myGivenPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myAllPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response : Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int){
        viewModelScope.launch {
            val response : Response<Post> = repository.getPost2(number)
            myResponse2.value = response
        }
    }


    fun getGivenPosts(userId: Int, options: Map<String, String>){
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getGivenPosts(userId, options)
            myGivenPosts.value = response
        }
    }

    fun getAllPosts(){
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getAllPosts()
            myAllPosts.value = response
        }


    }
}
