package com.owen.navigationdemo

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

/**
 *
 * <br/>Author：yunying.zhang
 * <br/>Email: yunyingzhang@rastar.com
 * <br/>Date: 2020/5/7
 */
class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("AAAA", "LoginFragment onCreateView")
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        view.findViewById<View>(R.id.btnRegister).setOnClickListener {
            val args = Bundle()
            args.putString("name", "Unknown")
            args.putInt("age", 0)
            args.putString("email", "Unknown")
            // 传递参数
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment, args)
        }

        arguments?.keySet()?.forEach {
            Log.e("BBBBB", "${it} ===== ${arguments?.get(it)}")
        }

        val etAccount =  view.findViewById<EditText>(R.id.etAccount);
        val account = arguments?.getString("uname");
        if(!TextUtils.isEmpty(account)) {
                etAccount.setText(account)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("AAAA", "LoginFragment onDestroyView")
    }

}