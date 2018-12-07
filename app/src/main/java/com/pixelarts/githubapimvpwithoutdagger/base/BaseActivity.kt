package com.pixelarts.githubapimvpwithoutdagger.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T: BasePresenter> : AppCompatActivity(), BaseView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun showMessagage(massage: String) {

    }

    override fun showError(error: String) {

    }

    abstract fun init()
    abstract fun getViewPreseter():T
}