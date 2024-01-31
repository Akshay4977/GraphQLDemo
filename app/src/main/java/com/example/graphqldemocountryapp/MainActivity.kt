package com.example.graphqldemocountryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.graphqldemocountryapp.presentation.CountriesScreen
import com.example.graphqldemocountryapp.presentation.CountriesViewModel
import com.example.graphqldemocountryapp.ui.theme.GraphQlCountriesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlCountriesAppTheme {
                val viewModel = hiltViewModel<CountriesViewModel>()
                val state by viewModel.state.collectAsState()
                CountriesScreen(
                    state = state,
                    onSelectedCountry = viewModel::selectCountry,
                    onDismissCountryDialog = viewModel::dismissCountryDialog
                )
            }
        }
    }
}