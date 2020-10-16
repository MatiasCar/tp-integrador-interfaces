package org.example.controllers

data class UserRegisterMapper( val name : String? = null,
                               val email : String? = null,
                               val password : String? = null,
                               val photo : String? = null
                               )


data class UserLoginMapper(val email: String?, val password: String?)