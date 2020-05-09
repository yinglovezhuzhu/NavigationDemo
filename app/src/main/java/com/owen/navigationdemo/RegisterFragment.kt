package com.owen.navigationdemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController

/**
 *
 * <br/>Author：yunying.zhang
 * <br/>Email: yunyingzhang@rastar.com
 * <br/>Date: 2020/5/7
 */
class RegisterFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("AAAA", "RegisterFragment onCreateView")
        val view = inflater.inflate(R.layout.fragment_register, container, false)


        view.findViewById<Button>(R.id.btnCancel).setOnClickListener {

            Navigation.findNavController(view).popBackStack()
        }


        // 读取参数
        Log.e("XXXXX", "Name: ${arguments?.getString("name")}")
        Log.e("XXXXX", "Age: ${arguments?.getInt("age", 0)}")
        Log.e("XXXXX", "Email: ${arguments?.getString("email")}")

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.e("AAAA", "RegisterFragment onDestroyView")
    }
}