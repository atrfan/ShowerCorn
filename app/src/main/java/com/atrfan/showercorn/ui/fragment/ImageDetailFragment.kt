package com.atrfan.showercorn.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.atrfan.showercorn.R
import com.atrfan.showercorn.bean.ImageDetailItem
import com.atrfan.showercorn.databinding.FragmentImageDetailBinding
import com.atrfan.showercorn.databinding.FragmentRecommendBinding
import com.atrfan.showercorn.network.response.DetailResponse
import com.atrfan.showercorn.ui.adapter.DetailTagAdapter
import com.atrfan.showercorn.ui.decoration.ImageGridItemDecoration
import com.atrfan.showercorn.util.ConvertTime.formatTime
import com.atrfan.showercorn.util.ShowToast.showToast
import com.bumptech.glide.Glide
import com.kongzue.dialogx.dialogs.WaitDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageDetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentImageDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailBinding = FragmentImageDetailBinding.inflate(inflater, container, false)
        initView(arguments?.getString("pid"))
        return detailBinding.root
    }

    private fun initView(pid: String?) {
        WaitDialog.show(R.string.loading)
        if (pid == null) {
            Toast.makeText(
                this.activity,
                R.string.networkError,
                Toast.LENGTH_SHORT
            ).show()
            WaitDialog.dismiss()
        } else {
            CoroutineScope(Dispatchers.Main).launch {
                val detail = withContext(Dispatchers.IO) {
                    DetailResponse().imageDetail(pid)
                }
                if (detail == null) {
                    Toast.makeText(
                        this@ImageDetailFragment.activity,
                        R.string.networkError,
                        Toast.LENGTH_SHORT
                    ).show()
                    WaitDialog.dismiss()
                } else {
                    bindingData(detail)
                    WaitDialog.dismiss()
                }
            }
        }
    }

    private fun bindingData(detail: ImageDetailItem) {
        detailBinding.let {
            Glide.with(this)
                .load(detail.imageUrl)
                .into(it.detailImage)
            Glide.with(this)
                .load(detail.userHeaderUrl)
                .into(it.userHeaderImg)

            it.detailUsername.text = detail.username
            it.detailUserId.text = detail.uid
            it.detailImageTitle.text = detail.imageTitle
            it.detailImageCaption.text = detail.imageCaption
            it.detailImagePid.text = detail.pid
            it.tvLikesDetail.text = detail.likes
            it.tvViewsDetail.text = detail.views
            it.tvUploadTime.text= detail.uploadTime.formatTime()
            val recyclerView = it.detailImageTags
            recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            recyclerView.adapter = DetailTagAdapter(detail.tags)
            val largePadding = resources.getDimensionPixelSize(R.dimen.tags_grid_spacing)
            val smallPadding = resources.getDimensionPixelSize(R.dimen.tags_grid_spacing_small)
            recyclerView.addItemDecoration(ImageGridItemDecoration(largePadding, smallPadding))

        }
    }

}