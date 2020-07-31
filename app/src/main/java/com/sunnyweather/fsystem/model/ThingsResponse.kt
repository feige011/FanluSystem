package com.sunnyweather.fsystem.model

import com.sunnyweather.fsystem.activity.ui.notifications.Project

/**
 * user
 */
data class ThingsResponse(val code: Int, val msg: String, val data: ThingsMe)

data class ThingsMe(
    val success: String,
    val account: String,
    val username: String
)

data class ThingsRegister(val code: Int, val msg: String, val data: Success)
data class Success(val success: String)
data class SearchLogin(var username: String, var password: String)

data class SearchRegister(
    var username: String, var account: String, var password: String,
    var secret_password1: String,
    var secret_password2: String,
    var secret_password3: String
)
data class ForgetPassword(
    var account: String, var password: String,
    var secret_password1: String,
    var secret_password2: String,
    var secret_password3: String
)

/**
 * project
 */
data class SearchProject(val code: Int, val msg: String, val data: AllProject)
data class AllProject(val data: List<Projects>)
data class Projects(
    val id: Int,
    val projectName: String,
    val sketchPorject: String,
    val mainProject: String,
    val manager: String,
    val member: String
)

data class ReleaseProject(val code: Int, val msg: String, val data: NewProject)
data class NewProject(val newProject: Projects)

data class ReleaseProjectMe(var account: String, var project:Project)



//data class Things()
/**
 *board
 */

data class boardThings(val boardName:String,val boardAccountName:String,val boardMainThings:String)
