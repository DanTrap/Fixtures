package com.danntrp.fixtures.fixtures.ui.stateholder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danntrp.fixtures.fixtures.core.Resource
import com.danntrp.fixtures.fixtures.domain.model.Fixture
import com.danntrp.fixtures.fixtures.domain.usecases.FixturesByDateUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class FixtureViewModel(
    private val fixtureUseCase: FixturesByDateUseCase
) : ViewModel() {

    private val _fixtures = MutableLiveData<Resource<List<Fixture>>>()
    val fixtures: LiveData<Resource<List<Fixture>>> = _fixtures

    fun getFixtures(fromDate: String, toDate: String) = viewModelScope.launch(
        CoroutineExceptionHandler { _, throwable ->
        _fixtures.postValue(
            when (throwable) {
                is IOException -> Resource.Error("Network")
                is HttpException -> Resource.Error("Server")
                else -> Resource.Error("Something")
            }
        )
    }) {
        _fixtures.postValue(Resource.Loading())
        _fixtures.postValue(fixtureUseCase.invoke(fromDate, toDate))
    }
}