package com.sunnyweather.fsystem.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sunnyweather.fsystem.R
import com.sunnyweather.fsystem.model.ForgetPassword
import com.sunnyweather.fsystem.model.ThingsViewModel
import kotlinx.android.synthetic.main.activity_login_forget_password.*
import kotlinx.android.synthetic.main.layout_register.*

class LoginForgetPassword : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this).get(ThingsViewModel::class.java) }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_forget_password)
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        setSupportActionBar(login_forget_toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
        }
        forget_button.setOnClickListener {
            if(forget_et_verificationCode.text.isEmpty()){
                Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show()
            }else if(forget_et_account.text.isEmpty()){
                Toast.makeText(this, "学号不能为空", Toast.LENGTH_SHORT).show()
            }else if(forget_et_phoneNumber.text.isEmpty()&&forget_et_juniorName.text.isEmpty()&&forget_et_seniorName.text.isEmpty()){
                Toast.makeText(this, "密保不能都为空", Toast.LENGTH_SHORT).show()
            }else if(forget_et_password.text.length < 6){
                Toast.makeText(this, "密码不能小于16位", Toast.LENGTH_SHORT).show()
            }else if(forget_et_password.text.toString() != forget_et_comfrimPassword.text.toString()){
                Toast.makeText(this,"前后密码不一致",Toast.LENGTH_SHORT).show()
            }else{
                val m=ForgetPassword(forget_et_account.text.toString(),
                    forget_et_password.text.toString(),
                    forget_et_phoneNumber.text.toString(),
                    forget_et_juniorName.text.toString(),
                    forget_et_seniorName.text.toString())
                viewModel.ChangePassword(m)
            }
            viewModel.LiveChangePassword.observe(this, Observer {
                val things=it.getOrNull()
                if(things!=null){
                    if(things.code==200){
                        Toast.makeText(this,things.data.success,Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(this,"学号或密保有问题",Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this,"学号或密保有问题",Toast.LENGTH_SHORT).show()
                }
            })
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                this.finish()
            }
        }
        return true
    }
}