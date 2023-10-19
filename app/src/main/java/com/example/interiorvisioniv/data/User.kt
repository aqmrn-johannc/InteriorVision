package com.example.interiorvisioniv.data

data class User(val id: Int,
                val name: String,
                val email: String,
                val password: String) {

    constructor(name: String, email: String, password: String) : this(0, name, email, password)
}
