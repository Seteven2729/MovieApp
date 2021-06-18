package com.dicoding.movieapp.core.utils

import android.content.Context
import com.dicoding.movieapp.core.R
import com.dicoding.movieapp.core.data.source.remote.response.CinemaDataResponses
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(): String? {
        val jsonString: String
        try {
            jsonString = context.resources.openRawResource(R.raw.cinemadata).bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun loadData(): List<CinemaDataResponses> {
        val list = ArrayList<CinemaDataResponses>()
        val responseObject = JSONObject(parsingFileToString().toString())
        val listArray = responseObject.getJSONArray("movies")
        for (i in 0 until listArray.length()) {
            val data = listArray.getJSONObject(i)

            val name = data.getString("name")
            val description = data.getString("description")
            val imagePath = data.getString("imagePath")

            val cinemaResponse = CinemaDataResponses(
                name = name,
                description = description,
                photo = imagePath.toInt()
            )
            list.add(cinemaResponse)
        }
        return list
    }
}

