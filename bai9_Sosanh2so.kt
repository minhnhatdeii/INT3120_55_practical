fun main() {
    val steps = 4000
    val caloriesBurned = calculateCaloriesBurned(steps);
    println("Walking $steps steps burns $caloriesBurned calories")
}

fun calculateCaloriesBurned(stepst: Int): Double {
    val caloriesPerStep = 0.04
    val totalCaloriesBurned = stepst * caloriesPerStep
    return totalCaloriesBurned
}