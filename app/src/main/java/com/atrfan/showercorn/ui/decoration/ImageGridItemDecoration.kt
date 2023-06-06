package com.atrfan.showercorn.ui.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author atrfan
 * @date 2023-03-18 10:41
 */
class ImageGridItemDecoration(private val largePadding: Int, private val smallPadding: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.left = smallPadding
        outRect.right = smallPadding
        outRect.top = largePadding
        outRect.bottom = largePadding
    }
}