package com.melihilhan.marveluniverseapp.util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = "aa92593d169ca7da8f46fade371b09fe"
        const val PRIVATE_KEY = "9feb9fee7866b7c7268e8c28639b013faddeacb5"
        const val limit = "20"

        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}