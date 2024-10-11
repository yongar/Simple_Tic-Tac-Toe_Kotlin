fun main() {
    // put your code here
    val str = readln()
    var currentChar = ' '
    var count = 0
    var outputString = ""
    for (char in str)
    {
        if (char == currentChar)
        {
            count++
        }
        else
        {
            if (count > 0)
            {
                outputString += "$currentChar$count"
            }
            currentChar = char
            count = 1
        }
    }
    if (count > 0 )
    {
        outputString += "$currentChar$count"
    }
    println(outputString)


}
