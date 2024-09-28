package com.example.kotlinfundamentals

class Song (
    var nameSong: String,
    var artist: String,
    var yearOfPulication: Int,
    var numOfPlay : Int
){
    val isPopular: Boolean
        get() = numOfPlay >= 1000

    fun printDescription() {
        println("$nameSong, do $artist thực hiện, được phát hành vào $yearOfPulication.")
    }

}