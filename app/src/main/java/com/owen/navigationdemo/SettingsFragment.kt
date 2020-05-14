package com.owen.navigationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController

/**
 *
 * <br/>Author：yunying.zhang
 * <br/>Email: yunyingzhang@rastar.com
 * <br/>Date: 2020/5/9
 */
class SettingsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        view.findViewById<TextView>(R.id.tvSettings1).setOnClickListener {
            // Kotlin 扩展方法检索当前导航宿主的导航控制器
            findNavController().navigate(R.id.action_settingsFragment_to_accountSettingsFragment)
        }
        view.findViewById<TextView>(R.id.tvSettings2).setOnClickListener {
            // Kotlin 扩展方法检索当前导航宿主的导航控制器
            findNavController().navigate(R.id.action_settingsFragment_to_safeSettingsFragment)
        }
        view.findViewById<TextView>(R.id.tvSettings3).setOnClickListener {
            // Kotlin 扩展方法检索当前导航宿主的导航控制器
            findNavController().navigate(R.id.action_settingsFragment_to_normalSettingsFragment)
        }

        return view
    }
}