package com.example.graphqldemocountryapp.domain


interface CountryClient {

    suspend fun getCountries(): List<SimpleCountry>

    suspend fun getCountry(code: String): DetailCountry?
}