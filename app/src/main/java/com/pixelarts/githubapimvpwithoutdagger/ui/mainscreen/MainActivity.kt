package com.pixelarts.githubapimvpwithoutdagger.ui.mainscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pixelart.week5daily1.model.APIResponse
import com.pixelarts.githubapimvpwithoutdagger.R
import com.pixelarts.githubapimvpwithoutdagger.base.BaseActivity
import com.pixelarts.githubapimvpwithoutdagger.repository.RepositoryImpl
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainActivity : BaseActivity<MainScreenContract.Presnter>(),MainScreenContract.View {

    private val TAG = "MainActivity"
    lateinit var presenter: MainScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainScreenPresenter.newInstance
        presenter.onCreate()
        getUsers("1509489")
    }

    override fun init() {

    }

    fun getUsers(username: String) {
        RepositoryImpl.newInstance.getUsers(username)
            .subscribe(object : SingleObserver<APIResponse> {
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

    override fun getViewPreseter(): MainScreenContract.Presnter = MainScreenPresenter.newInstance

    override fun showUsers(username: String) {

    }
}
