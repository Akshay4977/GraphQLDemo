package com.example.graphqldemocountryapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqldemocountryapp.domain.DetailCountry
import com.example.graphqldemocountryapp.domain.GetCountriesUseCase
import com.example.graphqldemocountryapp.domain.GetCountryUseCase
import com.example.graphqldemocountryapp.domain.SimpleCountry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state = _state

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            _state.update {
                it.copy(
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }
    }

    fun selectCountry(code: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    selectedCountry = getCountryUseCase.execute(code)
                )
            }
        }
    }

    fun dismissCountryDialog() {
        _state.update {
            it.copy(selectedCountry = null)
        }
    }

    data class CountriesState(
        val countries: List<SimpleCountry> = emptyList(),
        val isLoading: Boolean = false,
        val selectedCountry: DetailCountry? = null
    )
}