package com.pixelarts.githubapimvpwithoutdagger.remote


import com.pixelart.week5daily1.model.APIResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService{
    @GET("search/users")
    fun getUsers(@Query("q") user: String):Single<APIResponse>
}