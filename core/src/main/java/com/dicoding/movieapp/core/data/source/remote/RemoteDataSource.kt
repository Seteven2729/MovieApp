package com.dicoding.movieapp.core.data.source.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.movieapp.core.data.source.remote.network.ApiResponse
import com.dicoding.movieapp.core.data.source.remote.response.CinemaDataResponses
import com.dicoding.movieapp.core.utils.JsonHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.json.JSONException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val jsonHelper: JsonHelper) {
   suspend fun getAllMovie(): Flow<ApiResponse<List<CinemaDataResponses>>> {
       return flow {
           try {

               val dataArray = jsonHelper.loadData()
               if (dataArray.isNotEmpty()){
                   emit(ApiResponse.Success(dataArray))
               } else {
                   emit(ApiResponse.Empty)
               }
           } catch (e : Exception){
               emit(ApiResponse.Error(e.toString()))
               Log.e("RemoteDataSource", e.toString())
           }
       }.flowOn(Dispatchers.IO)

    }
}

