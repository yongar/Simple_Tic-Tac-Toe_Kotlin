fun main() {
    val grid = CharArray(9) { '_' }
    var currentPlayer = 'X'

    printGrid(grid)

    while (true) {
        println("Enter the coordinates:")
        val input = readln()

        try {
            val (row, col) = input.split(" ").map { it.toInt() - 1 }

            if (row in 0..2 && col in 0..2) {
                val index = row * 3 + col
                if (grid[index] == '_') {
                    grid[index] = currentPlayer
                    printGrid(grid)

                    val gameResult = analyzeGrid(grid)
                    if (gameResult != "Game not finished") {
                        println(gameResult)
                        break
                    }

                    currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
                } else {
                    println("This cell is occupied! Choose another one!")
                }
            } else {
                println("Coordinates should be from 1 to 3!")
            }
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
        } catch (e: IndexOutOfBoundsException) {
            println("You should enter two numbers separated by a space!")
        }
    }
}

fun printGrid(grid: CharArray) {
    println("---------")
    for (i in 0..2) {
        println("| ${grid[i * 3]} ${grid[i * 3 + 1]} ${grid[i * 3 + 2]} |")
    }
    println("---------")
}

fun analyzeGrid(grid: CharArray): String {
    // Check rows
    for (i in 0..2) {
        if (grid[i * 3] != '_' && grid[i * 3] == grid[i * 3 + 1] && grid[i * 3] == grid[i * 3 + 2]) {
            return "${grid[i * 3]} wins"
        }
    }

    // Check columns
    for (i in 0..2) {
        if (grid[i] != '_' && grid[i] == grid[i + 3] && grid[i] == grid[i + 6]) {
            return "${grid[i]} wins"
        }
    }

    // Check diagonals
    if ((grid[0] != '_' && grid[0] == grid[4] && grid[0] == grid[8]) ||
        (grid[2] != '_' && grid[2] == grid[4] && grid[2] == grid[6])
    ) {
        return "${grid[4]} wins"
    }

    // Check for draw
    if (grid.none { it == '_' }) {
        return "Draw"
    }

    return "Game not finished"
}
