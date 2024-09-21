
/* Buoc 1 */
fun main() {
    val firstNumber = 10
    val secondNumber = 5
	val result = firstNumber + secondNumber
    println("$firstNumber + $secondNumber = $result")
}
/**
 * Lỗi: Chua khoi tao bien Result và tính nó
 */

 /* BUoc 2 */
 fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
}

fun add(a : Int, b : Int) : Int {
    return a + b
}

/* Buoc 3 */
fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = subtract(firstNumber, secondNumber)
    val anotherResult = subtract(firstNumber, thirdNumber)

    println("$firstNumber - $secondNumber = $result")
    println("$firstNumber - $thirdNumber = $anotherResult")
}

fun subtract(a : Int, b : Int) : Int {
    return a - b
}