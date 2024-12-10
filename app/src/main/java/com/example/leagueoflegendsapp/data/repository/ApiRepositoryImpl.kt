package com.example.leagueoflegendsapp.data.repository

import com.example.leagueoflegendsapp.domain.model.ChampionResponseModel
import com.example.leagueoflegendsapp.domain.repository.ApiRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient

class ApiRepositoryImpl(
    private val httpClient: HttpClient
): ApiRepository {
    companion object{
        const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/14.23.1/data/en_US/"
    }
    override suspend fun getAllChampions(): ApiResponse<ChampionResponseModel> {
        return httpClient.getApiResponse {
            "champion.json"
        }
    }

    override suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel> {
        return httpClient.getApiResponse {
            "$name.json"
        }
    }
}