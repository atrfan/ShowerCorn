package com.atrfan.showercorn.data

import androidx.lifecycle.MutableLiveData
import com.atrfan.showercorn.R


object RecommendFragmentConfig {
    val resId: MutableLiveData<Int> = MutableLiveData(R.id.daily)
    val pages: HashMap<Int, Int> = hashMapOf(
        R.id.daily to 0,
        R.id.weekly to 0,
        R.id.monthly to 0,
        R.id.animal_ears to 0,
        R.id.white_hair to 0,
        R.id.fanart to 0,
        R.id.ai_painting to 0,
        R.id.illust to 0,
        R.id.manga to 0
    )
}

