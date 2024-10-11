fun main() {
    // write your code here
    val str = readln().lowercase().toCharArray()
    for (i in str.indices) {
        if (str[i] == 't' && str[i + 1] == 'h' && str[i + 2] == 'e') {
            println(i)
            break
        }
        else if (i == str.lastIndex) {
            println(-1)
        }
    }

}
