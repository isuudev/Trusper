package com.isuu.trusper.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.isuu.trusper.databinding.ActivityUserPhotoBinding
import com.isuu.trusper.model.gilde.GlideApp

class UserPhotoActivity : AppCompatActivity() {
    companion object {
        private const val ARG_IMAGE = "arg_image"

        fun startActivity(context: Context, url: String) {
            val intent = Intent()
            intent.setClass(context, UserPhotoActivity::class.java)
            intent.putExtra(ARG_IMAGE, url)
            context.startActivity(intent)
        }
    }

    private val binding: ActivityUserPhotoBinding by lazy {
        ActivityUserPhotoBinding.inflate(layoutInflater)
    }

    private val url: String by lazy {
        intent.getStringExtra(ARG_IMAGE) ?: ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }


    private fun initView() {
        val actionBar = supportActionBar as ActionBar
        actionBar.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        GlideApp.with(this).load(url).into(binding.imageView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this@UserPhotoActivity.finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}