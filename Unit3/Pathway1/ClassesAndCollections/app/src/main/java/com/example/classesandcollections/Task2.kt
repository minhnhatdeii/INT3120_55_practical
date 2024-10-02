package com.example.classesandcollections


data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}
fun main() {
    var a = Event(
        title="Study Kotlin",
        description="Commit to studying Kotlin at least 15 minutes per day.",
        daypart=Daypart.MORNING,
        durationInMinutes=15
    )
    println(a.toString())

}