package com.example.android_tema1

data class Animal(val name: String, val continent: String){
    override fun toString(): String {
        return "$name\n$continent"
    }
}