fun main() {
    fun part1(input: List<String>): Int {
        var result = ""
        for (i in 0 until input[0].length) {
            result += input.groupingBy { str -> str[i] }.eachCount().maxByOrNull { it.value }?.key
        }
        val x = result.toUInt(2).inv().toString(2).takeLast(input[0].length - 1)
        return result.toInt(2) * x.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val oxygenRating = input.toMutableList()
        val scrubberRating = input.toMutableList()
        for (i in 0 until input[0].length) {
            if (oxygenRating.size > 1) {
                val mostCommonMap = oxygenRating.groupingBy { str -> str[i] }.eachCount()
                val mostCommon = if (mostCommonMap['0'] == mostCommonMap['1']) {
                     '1'
                } else {
                    mostCommonMap.maxByOrNull { it.value }?.key ?: '1'
                }
                oxygenRating.removeAll { it[i] != mostCommon }
            }
            if (scrubberRating.size > 1) {
                val leastCommonMap = scrubberRating.groupingBy { str -> str[i] }.eachCount()
                val leastCommon = if (leastCommonMap['0'] == leastCommonMap['1']) {
                    '0'
                } else {
                    leastCommonMap.minByOrNull { it.value }?.key ?: '0'
                }
                scrubberRating.removeAll { it[i] != leastCommon }
            }
        }
        return oxygenRating[0].toInt(2) * scrubberRating[0].toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03/Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03/Day03")
    println(part1(input))
    println(part2(input))
}

