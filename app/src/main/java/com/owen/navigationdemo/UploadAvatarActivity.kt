package com.owen.navigationdemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActivityNavigator

/**
 *
 * <br/>Author：yunying.zhang
 * <br/>Email: yunyingzhang@rastar.com
 * <br/>Date: 2020/5/11
 */
class UploadAvatarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_upload_avatar)

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}