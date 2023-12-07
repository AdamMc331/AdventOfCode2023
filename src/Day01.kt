fun main() {
    val numWords = listOf(
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
    )

    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            val firstDigit = line.first(Char::isDigit).digitToInt()
            val lastDigit = line.last(Char::isDigit).digitToInt()

            (firstDigit * 10) + lastDigit
        }
    }

    fun getFirstDigit(line: String): Int {
        line.forEachIndexed { index, c ->
            if (c.isDigit()) {
                return c.digitToInt()
            }

            numWords.forEachIndexed { numStringIndex, numString ->
                if (line.substring(index).startsWith(numString)) {
                    return numStringIndex + 1
                }
            }
        }

        return -1
    }

    fun getLastDigit(line: String): Int {
        for (index in line.lastIndex downTo 0) {
            val c = line[index]

            if (c.isDigit()) {
                return c.digitToInt()
            }

            numWords.forEachIndexed { numStringIndex, numString ->
                if (line.substring(index).startsWith(numString)) {
                    return numStringIndex + 1
                }
            }
        }

        return -1
    }

    /**
     * Ideally for part 2, we just reprocess the data into a format that works well with part 1
     * Replace any string words with the digit they represent.
     */
    fun part2(input: List<String>): Int {
        return input.sumOf { line ->
            val firstDigit = getFirstDigit(line)
            val lastDigit = getLastDigit(line)

            (firstDigit * 10) + lastDigit
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
