package com.atrfan.showercorn.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.atrfan.showercorn.R
import com.atrfan.showercorn.bean.ImageItem
import com.atrfan.showercorn.data.RecommendFragmentConfig.resId
import com.atrfan.showercorn.data.RecommendFragmentConfig.pages
import com.atrfan.showercorn.databinding.FragmentRecommendBinding
import com.atrfan.showercorn.network.response.ListResponse
import com.atrfan.showercorn.ui.adapter.RecommendListAdapter
import com.atrfan.showercorn.ui.decoration.ImageGridItemDecoration
import com.kongzue.dialogx.dialogs.WaitDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RecommendFragment : Fragment() {

    private lateinit var binding: FragmentRecommendBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendBinding.inflate(inflater, container, false)
        refreshUi(true)
        resId.observe(
            viewLifecycleOwner
        ) {
            refreshUi(false)
        }
        return binding.root
    }


    private fun refreshUi(flag: Boolean) {
        WaitDialog.show(R.string.loading)
        CoroutineScope(Dispatchers.Main).launch {
            val list = withContext(Dispatchers.IO) {
                when (resId.value) {
                    R.id.daily -> ListResponse().allRank(
                        "daily",
                        pages[resId.value]!!
                    )

                    R.id.weekly -> ListResponse().allRank(
                        "weekly",
                        pages[resId.value]!!
                    )

                    R.id.monthly -> ListResponse().allRank(
                        "monthly",
                        pages[resId.value]!!
                    )

                    R.id.animal_ears -> ListResponse().rankByTag(
                        "猫耳",
                        pages[resId.value]!!
                    )

                    R.id.white_hair -> ListResponse().rankByTag(
                        "白毛",
                        pages[resId.value]!!
                    )

                    R.id.fanart -> ListResponse().rankByTag(
                        "同人",
                        pages[resId.value]!!
                    )

                    R.id.ai_painting -> ListResponse().rankByTag(
                        "ai",
                        pages[resId.value]!!
                    )

                    R.id.illust -> ListResponse().rankByWorkType(
                        "illust",
                        pages[resId.value]!!
                    )

                    R.id.illust -> ListResponse().rankByWorkType(
                        "manga",
                        pages[resId.value]!!
                    )

                    else -> mutableListOf<ImageItem>()
                }
            }

            if (list.size == 0) {
                Toast.makeText(
                    this@RecommendFragment.activity,
                    R.string.networkError,
                    Toast.LENGTH_SHORT
                ).show()
                WaitDialog.dismiss()
            } else {
                val recyclerView = binding.imagesList
                recyclerView.layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                recyclerView.adapter = RecommendListAdapter(context, list)
                val largePadding = resources.getDimensionPixelSize(R.dimen.image_grid_spacing)
                val smallPadding = resources.getDimensionPixelSize(R.dimen.image_grid_spacing_small)
                if (flag) {
                    recyclerView.addItemDecoration(
                        ImageGridItemDecoration(
                            largePadding,
                            smallPadding
                        )
                    )
                }
                WaitDialog.dismiss()
            }
        }
    }
}