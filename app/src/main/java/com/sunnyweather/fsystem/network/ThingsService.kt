package com.sunnyweather.fsystem.network


import com.sunnyweather.fsystem.model.ReleaseProject
import com.sunnyweather.fsystem.model.SearchProject
import com.sunnyweather.fsystem.model.ThingsRegister
import com.sunnyweather.fsystem.model.ThingsResponse
import retrofit2.Call
import retrofit2.http.*

interface ThingsService {
    /**
     * user
     */
    @GET("user/checkAccount")
    fun testAccount(@Query("account") account: String): Call<ThingsRegister>

    @FormUrlEncoded
    @POST("user/register")
    fun searchRegister(
        @Field("username") name: String,
        @Field("account") account: String,
        @Field("password") password: String,
        @Field("secret_password1") secret_password1: String,
        @Field("secret_password2") secret_password2: String,
        @Field("secret_password3") secret_password3: String
    ): Call<ThingsRegister>

    @FormUrlEncoded
    @POST("user/login")
    fun searchLogin(
        @Field("account") account: String,
        @Field("password") password: String
    ): Call<ThingsResponse>



    @FormUrlEncoded
    @POST("user/updatePassword")
    fun changePassword(
        @Field("account") account: String,
        @Field("newPassword") password: String,
        @Field("secret_password1") secret_password1: String,
        @Field("secret_password2") secret_password2: String,
        @Field("secret_password3") secret_password3: String
    ): Call<ThingsRegister>

    /**
    * project
    */
    @GET("project/getAllProjects")
    fun searchAllProject(): Call<SearchProject>

    @FormUrlEncoded
    @POST("project/releaseProject")
    fun releaseProject(
        @Field("account") account:String,
        @Field("projectName") projectName:String,
        @Field("sketchPorject")sketchPorject:String,
        @Field("mainProject")mainProject:String
    ):Call<ReleaseProject>
}