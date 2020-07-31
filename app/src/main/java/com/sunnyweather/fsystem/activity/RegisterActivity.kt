package com.sunnyweather.fsystem.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sunnyweather.fsystem.R
import com.sunnyweather.fsystem.model.ThingsViewModel
import kotlinx.android.synthetic.main.layout_register.*

class RegisterActivity : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this).get(ThingsViewModel::class.java) }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        register_bt_register.setOnClickListener {
            if (register_et_account.text.isEmpty()) {
                Toast.makeText(this, "学号不能为空", Toast.LENGTH_SHORT).show()
            } else if (register_et_verificationCode.text.isEmpty()) {
                Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show()
            } else if (register_et_phoneNumber.text.isEmpty() || register_et_juniorName.text.isEmpty() || register_et_seniorName.text.isEmpty()) {
                Toast.makeText(this, "密保不能为空", Toast.LENGTH_SHORT).show()
            } else if (register_et_password.text.length < 6) {
                Toast.makeText(this, "密码长度不得小于6位", Toast.LENGTH_SHORT).show()
            } else if (register_et_password.text.toString() != register_et_comfrimPassword.text.toString()) {
                Toast.makeText(this, "前后密码不一致", Toast.LENGTH_SHORT).show()
            } else {
//                viewModel.searchRegister(
//                    register_et_verificationCode.text.toString(),
//                    register_et_account.text.toString(),
//                    register_et_password.text.toString(),
//                    register_et_phoneNumber.text.toString(),
//                    register_et_juniorName.text.toString(),
//                    register_et_seniorName.text.toString()
//                )
                viewModel.SearchtextAccount(register_et_account.text.toString())
            }
            val imm =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val isOpen = imm.isActive
                if(isOpen){
                    imm.hideSoftInputFromWindow(this.currentFocus?.windowToken
                        ,InputMethodManager.HIDE_NOT_ALWAYS);
                }

        }
        viewModel.LiveDatatextAccount.observe(this, Observer {
            val things=it.getOrNull()
            if(things!=null){
                if (things.code==200){
                    viewModel.searchRegister(
                        register_et_verificationCode.text.toString(),
                        register_et_account.text.toString(),
                        register_et_password.text.toString(),
                        register_et_phoneNumber.text.toString(),
                        register_et_juniorName.text.toString(),
                        register_et_seniorName.text.toString()
                    )
                }else{
                    Toast.makeText(this,"学号已被注册",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"学号已被注册",Toast.LENGTH_SHORT).show()
            }
        })


        viewModel.placeLiveData.observe(this, Observer {
            val things = it.getOrNull()
            if (things != null) {
                if (things.code == 200) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                Log.e("feifei", things.code.toString())
                Log.e("feifei", things.msg)
                Log.e("feifei", things.data.success)
//                Log.e("feifei", things.data.msg)
            } else {
                Log.e("feifei", "shibai333333")
            }
        })

    }
}