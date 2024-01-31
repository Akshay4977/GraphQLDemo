package com.example.graphqldemocountryapp.domain

data class DetailCountry(
    val code: String,
    val name: String,
    val capital: String,
    val currency: String,
    val emoji: String
)