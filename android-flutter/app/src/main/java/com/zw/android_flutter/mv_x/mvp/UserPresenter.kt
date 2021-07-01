package com.zw.android_flutter.mv_x.mvp

class UserPresenter constructor(var i:OnLoginListener){
    fun login(user:User){
        i.onLogin(user)
    }
}