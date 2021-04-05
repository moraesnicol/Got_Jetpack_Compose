package com.example.gotjetpackcompose

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gotjetpackcompose.data.Episode
import com.example.gotjetpackcompose.data.SeriesService
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(
    private val seriesService: SeriesService
) : ViewModel() {

    private  val _episodesData = MutableLiveData<List<Episode>>()
    val episodesData: LiveData<List<Episode>>
        get() = _episodesData

    fun getSeries() {
    viewModelScope.launch {
        try {
        val series = seriesService.getGotSeasonOne()
            for (episode in series.episodes) {
                val poster = seriesService.getPoster(episode.imdbId)
                episode.posterUrl = poster.url
            }
         } catch (e: Exception) {
            Log.d("Service Error:", e.toString())
        }
    }
    }
}