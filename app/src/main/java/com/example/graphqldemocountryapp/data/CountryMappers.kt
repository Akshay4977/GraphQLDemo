package com.example.graphqldemocountryapp.data

import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.graphqldemocountryapp.domain.DetailCountry
import com.example.graphqldemocountryapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailsCountry(): DetailCountry {
    return DetailCountry(
        code = code,
        name = name,
        capital = capital ?: "no capital",
        currency = currency ?: "no currency",
        emoji = emoji ?: "no currency"
    )
}


fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        capital = capital ?: "no capital",
        emoji = emoji ?: "no currency"
    )
}