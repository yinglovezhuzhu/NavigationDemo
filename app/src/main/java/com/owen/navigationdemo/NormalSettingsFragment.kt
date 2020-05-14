package com.owen.navigationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 *
 * <br/>Author：yunying.zhang
 * <br/>Email: yunyingzhang@rastar.com
 * <br/>Date: 2020/5/12
 */
class NormalSettingsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings_normal, container, false)

        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            findNavController().popBackStack()
        }

        view.findViewById<Button>(R.id.btnMore).setOnClickListener {
            findNavController().navigate(R.id.action_to_settings_more)
        }

        return view
    }
}