fun main() {
    val timeSpentToday = 250
    val timeSpentYesterday = 300
    println(compare(timeSpentToday, timeSpentYesterday))
}
fun compare(timeSpentToday: Int, timeSpentYesterday : Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}
