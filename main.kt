fun main() {
    println(sol("aa", "ab"))
    println(sol("aa", "aab"))
}

fun sol(ransomNote: String, magazine: String): Boolean {
    // Initialize lists of word letter's frequencies with 0
    // firstWordLetterFreqs[i] = number of times char('a' + i) appears in first word 
    val firstWordLetterFreqs = MutableList(26) { 0 }
    val secondWordLetterFreqs = MutableList(26) { 0 }

    // Store the length of lists for further use
    val firstWordLen = ransomNote.length
    val secondWordLen = magazine.length

    // Iterate through both words letter's and update letter frequncy
    var i = 0
    while (i < firstWordLen && i < secondWordLen) {
        val firstWordChar: Char = ransomNote[i]
        val secondWordChar: Char = magazine[i]
        val firstIndex: Int = firstWordChar - 'a'
        val secondIndex: Int = secondWordChar - 'a'

        firstWordLetterFreqs[firstIndex]++
        secondWordLetterFreqs[secondIndex]++
        i++
    }

    // If there are uncounted letters in first word,
    // then iterate and update letter frequency
    while (i < firstWordLen) {
        val firstWordChar: Char = ransomNote[i]
        val firstIndex: Int = firstWordChar - 'a'

        firstWordLetterFreqs[firstIndex]++
        i++
    }

    // If there are uncounted letters in second word,
    // then iterate and update letter frequency
    while (i < secondWordLen) {
        val secondWordChar: Char = magazine[i]
        val secondIndex: Int = secondWordChar - 'a'

        secondWordLetterFreqs[secondIndex]++
        i++
    } 

    // Compare letter frequencies of both words
    // If first word can't be constructed using words from second word
    // then return false
    for (j in 0..firstWordLetterFreqs.size - 1) {
        if (firstWordLetterFreqs[j] > 0) {
            if (secondWordLetterFreqs[j] < firstWordLetterFreqs[j]) {
                return false
            }
        }
    }

    return true
}