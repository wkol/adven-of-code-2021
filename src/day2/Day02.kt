package day2
import readInput

val commandsHorizDepthMap = mapOf("forward" to listOf(1, 0), "up" to listOf(0, -1), "down" to listOf(0, 1))
val newCommands = mapOf("down" to 1, "up" to -1)

fun main() {
    fun part1(input: List<String>): Int {
        val horizontalDepthPosition = mutableListOf(0, 0)
        for (element in input) {
            val command = element.split(" ")
            horizontalDepthPosition[0] += (commandsHorizDepthMap[command[0]]?.get(0) ?: 0) * command[1].toInt()
            horizontalDepthPosition[1] += (commandsHorizDepthMap[command[0]]?.get(1) ?: 0) * command[1].toInt()
        }
        return horizontalDepthPosition[0] * horizontalDepthPosition[1]
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        var horizontal = 0
        var depth = 0
        for (element in input) {
            val command = element.split(" ")
            if (command[0] == "forward") {
                horizontal += command[1].toInt()
                depth += aim * command[1].toInt()
            }
            else {
                aim += newCommands[command[0]]?.times(command[1].toInt()) ?: 0
            }
        }
        return depth * horizontal
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day2/Day02_test")
    check(part1(testInput) == 150)

    val testInput2 = readInput("day2/Day02_test")
    check(part2(testInput2) == 900)

    val input = readInput("day2/Day02")
    println(part1(input))
    println(part2(input))
}
