package com.owen.navigationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController

/**
 *
 * <br/>Author：yunying.zhang
 * <br/>Email: yunyingzhang@rastar.com
 * <br/>Date: 2020/5/9
 */
class HomeFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<TextView>(R.id.btnStart).setOnClickListener {
            // Kotlin 扩展方法检索当前导航宿主的导航控制器
            val navController = findNavController()
            navController.navigate(R.id.action_homeFragment_to_loginFragment, Bundle().also {
                it.putInt("type", 2)
            })
        }

        view.findViewById<TextView>(R.id.tvSettings).setOnClickListener {
            findNavController().navigate(R.id.action_home_to_settings)
        }

        view.findViewById<TextView>(R.id.tvDeepLink1).setOnClickListener {

            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                showNotification(requireContext().applicationContext)
                Toast.makeText(requireContext(), "通知已发送，请点击通知栏的通知测试效果", Toast.LENGTH_LONG).show()
            }, 3000)
        }

        return view
    }


    private fun showNotification(context: Context) {
        var notificationManager:NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager = context.getSystemService<NotificationManager>(NotificationManager::class.java)
            if (null != notificationManager) {
                val channel = NotificationChannel("default", "default", NotificationManager.IMPORTANCE_DEFAULT
                )
                notificationManager.createNotificationChannel(channel)
            }
        } else {
            notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }

        val pendingIntent = findNavController().createDeepLink()
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.accountSettingFragment)
            .createPendingIntent()

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, "default")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("测试深层链接")
            .setContentText("测试显示深层链接打开应用")
            .setContentIntent(pendingIntent) //                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            .setAutoCancel(true)


        notificationManager.notify(1, builder.build())
    }
}