fun main() {
    // put your code here
    val letter = readln().first().lowercaseChar()

    for (ch in 'a' until letter) {
        print(ch)
    }
}
