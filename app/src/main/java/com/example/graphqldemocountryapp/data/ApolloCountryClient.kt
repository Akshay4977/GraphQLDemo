package com.example.graphqldemocountryapp.data

import com.apollographql.apollo3.ApolloClient
import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.graphqldemocountryapp.domain.CountryClient
import com.example.graphqldemocountryapp.domain.DetailCountry
import com.example.graphqldemocountryapp.domain.SimpleCountry

class ApolloCountryClient(private val apolloClient: ApolloClient) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailsCountry()
    }
}
