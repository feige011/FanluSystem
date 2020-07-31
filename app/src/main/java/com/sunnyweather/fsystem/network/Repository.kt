package com.sunnyweather.fsystem.network

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.liveData
import com.sunnyweather.fsystem.activity.ui.notifications.Project
import com.sunnyweather.fsystem.model.*
import kotlinx.coroutines.Dispatchers

object Repository {
    fun searchThings(searchRegister: SearchRegister) = liveData(Dispatchers.IO) {
        val result: Result<ThingsRegister> = try {
            val thingsResponse = ThingsNetwork.searchRegister(searchRegister)
            if (thingsResponse.code == 200) {
//                    Log.e("feifei","????????????????????")
                val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            } else {
//                    Log.e("feifei","????????????????????2")
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message)
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }


    fun searchLogin(searchLogin: SearchLogin) = liveData(Dispatchers.IO) {
        val result: Result<ThingsResponse> = try {
            val thingsResponse = ThingsNetwork.searchLogin(searchLogin)
            if (thingsResponse.code != 0) {
                Log.e("feifei", "????????????????????222")
                val Things = thingsResponse
                Log.e("feifei", "${Things.code}")
                Result.success(Things)
            } else {
//                Log.e("feifei","????????????????????22")
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message)
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }


    fun textAccount(account: String) = liveData(Dispatchers.IO) {
        val result: Result<ThingsRegister> = try {
            val thingsResponse = ThingsNetwork.testAccount(account)
            if (thingsResponse.code == 200) {
                Log.e("feifei", "????????????????????222")
                val Things = thingsResponse
                Log.e("feifei", "${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei", "????????????????????22")
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message)
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }

    //    searchAllProject
    fun searchAllProject() = liveData(Dispatchers.IO) {
        val result: Result<SearchProject> = try {
            val thingsResponse = ThingsNetwork.searchAllProject()
            if (thingsResponse.code == 200) {
                Log.e("feifei", "????????????????????222")
                val Things = thingsResponse
                Log.e("feifei", "${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei", "????????????????????333333")
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message)
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }

    fun changePassword(forgetPassword:ForgetPassword) = liveData(Dispatchers.IO) {
        val result: Result<ThingsRegister> = try {
            val thingsResponse = ThingsNetwork.changePassword(forgetPassword)
            if (thingsResponse.code != 0) {
                Log.e("feifei", "????????????????????222")
                val Things = thingsResponse
                Log.e("feifei", "${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei",thingsResponse.code.toString())
                Log.e("feifei", "????????????????????333333")
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message)
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }

    fun  releaseProject(releaseProjectMe:ReleaseProjectMe) = liveData(Dispatchers.IO) {
        val result: Result<ReleaseProject> = try {
            val thingsResponse = ThingsNetwork.releaseProject(releaseProjectMe)
            if (thingsResponse.code != 0) {
                Log.e("feifei", "????????????????????222")
                val Things = thingsResponse
                Log.e("feifei", "${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei",thingsResponse.code.toString())
                Log.e("feifei", "????????????????????333333")
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message)
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }
}