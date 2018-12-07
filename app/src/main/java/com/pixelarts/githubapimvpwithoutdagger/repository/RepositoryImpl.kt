package com.pixelarts.githubapimvpwithoutdagger.repository

import com.pixelart.week5daily1.model.APIResponse
import com.pixelarts.githubapimvpwithoutdagger.remote.RemoteHelper
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RepositoryImpl: Repository {

    private object Holder{
        val INSTANCE = RepositoryImpl.newInstance
    }
    companion object {
        val newInstance: RepositoryImpl by lazy {
            Holder.INSTANCE
        }
    }

    override fun getUsers(username: String):Single<APIResponse>{
        return RemoteHelper.getUsers(username)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    }
}