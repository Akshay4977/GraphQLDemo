package com.example.graphqldemocountryapp.domain

class GetCountryUseCase(val countryClient: CountryClient) {

    suspend fun execute(code: String): DetailCountry? {
        return countryClient.getCountry(code)
    }
}