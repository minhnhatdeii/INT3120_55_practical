fun main() {

    val caculCtoF: (Double) -> Double = {
        9.0/5.0 * it + 32
    }
    printFinalTemperature(27.0, "Celsius", "Fahrenheit", caculCtoF)

    val caculKtoC: (Double) -> Double = {
        it - 273.15
    }
    printFinalTemperature(350.0, "Kelvin", "Celsius", caculKtoC)

    val caculFtoK: (Double) -> Double = {
        5.0/9.0 * (it - 32) + 273.15
    }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", caculFtoK)
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}