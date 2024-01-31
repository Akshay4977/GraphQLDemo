package com.example.graphqldemocountryapp.di

import com.apollographql.apollo3.ApolloClient
import com.example.graphqldemocountryapp.data.ApolloCountryClient
import com.example.graphqldemocountryapp.domain.CountryClient
import com.example.graphqldemocountryapp.domain.GetCountriesUseCase
import com.example.graphqldemocountryapp.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getApolloClient(): ApolloClient {
        return ApolloClient.Builder().serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun getCountryClient(apolloClient: ApolloClient): CountryClient {
        return ApolloCountryClient(apolloClient)
    }


    @Provides
    @Singleton
    fun getCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase {
        return GetCountriesUseCase(countryClient)
    }

    @Provides
    @Singleton
    fun getCountryUseCase(countryClient: CountryClient): GetCountryUseCase {
        return GetCountryUseCase(countryClient)
    }
}