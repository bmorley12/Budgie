package com.example.budgie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform