package edu.metrostate.ics342.mediatracker.ui.search

import androidx.lifecycle.ViewModel
import edu.metrostate.ics342.mediatracker.data.fakeSearchResults
import edu.metrostate.ics342.mediatracker.data.model.Media
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {

    private val pageSize = 20
    private var currentPage = 1

    private val _results = MutableStateFlow<List<Media>>(
        fakeSearchResults.take(pageSize)
    )
    val results = _results.asStateFlow()

    fun loadNextPage() {
        val nextItems = fakeSearchResults.take((currentPage + 1) * pageSize)

        if (nextItems.size > _results.value.size) {
            currentPage++
            _results.value = nextItems
        }
    }
}