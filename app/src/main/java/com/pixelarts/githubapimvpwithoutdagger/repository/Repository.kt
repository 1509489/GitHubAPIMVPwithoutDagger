package com.pixelarts.githubapimvpwithoutdagger.repository

import com.pixelart.week5daily1.model.APIResponse
import io.reactivex.Single

interface Repository {
    fun getUsers(username: String):Single<APIResponse>
}