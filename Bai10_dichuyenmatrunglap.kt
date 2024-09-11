fun main() {
    weatherForecast("Ankara", 27, 31, 82)
    weatherForecast("Tokyo", 32, 36, 10)
    weatherForecast("Cape Town", 59, 64, 2)
    weatherForecast("Guatemala City", 50, 55, 7)
}
fun weatherForecast (city : String, lowT : Int, highT : Int, chanceR : Int) : Unit {
    println("City: $city")
    println("Low temperature: $lowT, High temperature: $highT")
    println("Chance of rain: $chanceR%")
    println()
}