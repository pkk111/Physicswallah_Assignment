package com.example.physicswallah

import com.example.physicswallah.Data.ProfessorsData.ProfessorModel
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("easygautam/data/users")
    suspend fun getAllMovies() : Response<List<ProfessorModel>>

}