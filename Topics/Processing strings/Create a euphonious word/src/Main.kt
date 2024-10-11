fun main() {
    val word = readln()
    println(minInsertions(word))
}

fun minInsertions(word: String): Int {
    var insertions = 0
    var consecutiveVowels = 0
    var consecutiveConsonants = 0

    for (i in word.indices) {
        if (isVowel(word[i])) {
            consecutiveVowels++
            consecutiveConsonants = 0
            if (consecutiveVowels >= 3) {
                insertions++
                consecutiveVowels = 1 // Reset after insertion
            }
        } else {
            consecutiveConsonants++
            consecutiveVowels = 0
            if (consecutiveConsonants >= 3) {
                insertions++
                consecutiveConsonants = 1 // Reset after insertion
            }
        }
    }

    return insertions
}

fun isVowel(char: Char): Boolean {
    val vowels = "aeiouy"
    return vowels.contains(char.lowercaseChar())
}
