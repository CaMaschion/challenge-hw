package com.challenge_hw.ui.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.challenge_hw.data.models.Property
import com.challenge_hw.data.repository.PropertyRepository
import com.challenge_hw.data.repository.RateRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class PropertyViewModel(
    private val propertyRepository: PropertyRepository,
    private val rateRepository: RateRepository

    ) : ViewModel() {

    var propertiesState by mutableStateOf<List<Property>>(emptyList())
        private set

    private val disposable = CompositeDisposable()

    fun fetchProperties() {
        propertyRepository.getProperties()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(
                { response ->
                    propertiesState = response.properties // update the state
                },
                { error ->
                    println("Error fetching properties: ${error.message}")
                }
            )
            .addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
