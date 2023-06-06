package com.atrfan.showercorn

import android.app.Application
import com.kongzue.dialogx.DialogX

class ShowerCornApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        DialogX.init(this)
        DialogX.onlyOnePopTip = true
    }
}