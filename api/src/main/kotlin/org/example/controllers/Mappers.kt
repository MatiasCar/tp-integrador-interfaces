package org.example.controllers

import org.ui.Comment

data class UserRegisterMapper( val name : String? = null,
                               val email : String? = null,
                               val password : String? = null,
                               val photo : String? = null
                               )


data class UserLoginMapper(val email: String?, val password: String?)

data class UserInfoMapper(val name: String?, val email: String?, val photo: String?)

data class NoteInfo(val id : String?,val title : String?, val body : String?, val categories : List<String>, val author : String?, val comments : MutableList<Comment>?)