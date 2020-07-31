package com.sunnyweather.fsystem.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.fsystem.network.Repository

class ThingsViewModel : ViewModel() {
    val searchLiveData = MutableLiveData<SearchRegister>()
    val placeList = ArrayList<ThingsMe>()
    val placeLiveData = Transformations.switchMap(searchLiveData) {
        Log.e("feifei", "shibai")
        Repository.searchThings(it)
    }

    fun searchRegister(
        name: String, queryAdmin: String, queryPassword: String, secret_password1: String,
        secret_password2: String,
        secret_password3: String
    ) {
        Log.e("feifei", "shibai3")
        val m = SearchRegister(
            name, queryAdmin, queryPassword, secret_password1,
            secret_password2,
            secret_password3
        )
        searchLiveData.value = m
        Log.e("feifei", m.username)
    }

    val searchLogin = MutableLiveData<SearchLogin>()
    val placeLiveDataLogin = Transformations.switchMap(searchLogin) {
        Log.e("feifei", "shibai")
        Repository.searchLogin(it)
    }
    fun searchLogin(queryAdmin: String, queryPassword: String) {
        Log.e("feifei", "shibai3")
        val m = SearchLogin(queryAdmin, queryPassword)
        searchLogin.value = m
        Log.e("feifei", m.username)
    }


    val textAccount=MutableLiveData<String>()
    val LiveDatatextAccount = Transformations.switchMap(textAccount) {
        Log.e("feifei", "shibai33333333333")
        Repository.textAccount(it)
    }
    fun SearchtextAccount(queryAdmin: String){
        textAccount.value=queryAdmin
    }


    val searchProject=MutableLiveData<String>()
    val LivesearchProject = Transformations.switchMap(searchProject) {
        Log.e("feifei", "shibai33333333333")
        Repository.searchAllProject()
    }
    fun SearchAllProject(queryAdmin: String){
        searchProject.value=queryAdmin
    }

    val changePassword=MutableLiveData<ForgetPassword>()
    val LiveChangePassword=Transformations.switchMap(changePassword){
        Repository.changePassword(it)
    }
    fun ChangePassword(forgetPassword:ForgetPassword){
        changePassword.value=forgetPassword
    }

    val  releaseProject= MutableLiveData<ReleaseProjectMe>()
    val LiveReleaseProject=Transformations.switchMap(releaseProject){
        Repository.releaseProject(it)
    }
    fun ReleaseProject(releaseProjectMe:ReleaseProjectMe){
        releaseProject.value=releaseProjectMe
    }




}