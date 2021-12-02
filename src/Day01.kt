fun main() {
    fun part1(input: List<String>): Int {
        var counter = 0
        for (i in 0..input.size - 2) {
            if(input[i] < input[i + 1]) {
                counter++
            }
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        for (i in 0..input.size - 4) {
            if (input.subList(i, i+3).sumOf { it.toInt() } < input.subList(i+1, i+4).sumOf { it.toInt() })
                counter++
        }
        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val testInput2 = readInput("Day01_test")
    check(part2(testInput2) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
