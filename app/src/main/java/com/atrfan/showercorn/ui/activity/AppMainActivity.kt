package com.atrfan.showercorn.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.atrfan.showercorn.R
import com.atrfan.showercorn.data.RecommendFragmentConfig
import com.atrfan.showercorn.databinding.ActivityMainAppBinding

class AppMainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainAppBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        setSupportActionBar(binding.toolbar)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        binding.navView.setCheckedItem(R.id.daily)
        binding.navView.setNavigationItemSelectedListener {
            // 监听事件
            RecommendFragmentConfig.resId.value = it.itemId
            binding.navView.setCheckedItem(it.itemId)
            binding.drawerLayout.closeDrawers()
            true
        }

        // 去fragment管理器里面通过id找到NavHostFragment
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        // 方法一：
        binding.bottomNavView.setupWithNavController(navHostFragment.navController)
        navHostFragment.navController.addOnDestinationChangedListener{ controller,destination,arguments ->
            when(destination.id){
                R.id.image_detail -> {
                    binding.bottomNavView.visibility = View.GONE
                    binding.toolbar.visibility = View.GONE
                    setTheme(R.style.ImageDetailTheme)
                }
                else -> {
                    binding.bottomNavView.visibility = View.VISIBLE
                    binding.toolbar.visibility = View.VISIBLE
                    setTheme(R.style.Theme_ShowerCorn)
                }
            }
        }
        /*
        方法二：
        val navController = navHostFragment.findNavController()
        NavigationUI.setupWithNavController(
            binding.bottomNavView,navController
        )
        */
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return true
    }



}

