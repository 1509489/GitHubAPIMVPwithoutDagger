package com.pixelarts.githubapimvpwithoutdagger.ui.mainscreen

import android.util.Log
import com.pixelart.week5daily1.model.APIResponse
import com.pixelarts.githubapimvpwithoutdagger.repository.RepositoryImpl
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainScreenPresenter (private val view: MainScreenContract.View): MainScreenContract.Presnter{
    private val TAG = "MainScreenPresenter"
    lateinit var repositoryImpl: RepositoryImpl

    private object Holder{
        val INSTANCE = MainScreenPresenter.newInstance
    }
    companion object {
        val newInstance: MainScreenPresenter by lazy {
            Holder.INSTANCE
        }
    }

    override fun getUsers(username: String) {
        RepositoryImpl.newInstance.getUsers(username)
            .subscribe(object : SingleObserver<APIResponse>{
                override fun onSuccess(t: APIResponse) {
                    for (i in 0 until t.items.size){
                        Log.d(TAG, t.items[i].login)
                    }
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            })
    }

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    override fun onCreate() {
        repositoryImpl = RepositoryImpl.newInstance
    }

}