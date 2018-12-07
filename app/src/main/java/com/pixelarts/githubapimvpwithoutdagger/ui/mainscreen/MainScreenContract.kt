package com.pixelarts.githubapimvpwithoutdagger.ui.mainscreen

import com.pixelarts.githubapimvpwithoutdagger.base.BasePresenter
import com.pixelarts.githubapimvpwithoutdagger.base.BaseView

interface MainScreenContract{
    interface View: BaseView{
        fun showUsers(username: String)
    }

    interface Presnter: BasePresenter{
        fun getUsers(username: String)
    }
}