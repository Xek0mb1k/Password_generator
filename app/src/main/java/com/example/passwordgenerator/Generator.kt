package com.example.passwordgenerator

class Generator {
    var lib: MutableList<String> = mutableListOf()
    var password: String = ""

    fun generate(
        length: Int,
        uppercaseLetters: Boolean,
        lowercaseLetters: Boolean,
        numbers: Boolean,
        symbols: Boolean,
        uniqueCharacters: Boolean
    ): String {

        createLibrary(
            uppercaseLetters,
            lowercaseLetters,
            numbers, symbols
        )

        if (uniqueCharacters) {
            if (length > lib.size)
                return ""
            generateUniqueCharactersPassword(length)
        } else {
            generatePassword(length)
        }
        return password
    }

    private fun createLibrary(
        uppercaseLetters: Boolean,
        lowercaseLetters: Boolean,
        numbers: Boolean,
        symbols: Boolean,
    ) {
        if (uppercaseLetters)
            for (i in 65..90) lib.add(i.toChar().toString())

        if (lowercaseLetters)
            for (i in 97..122) lib.add(i.toChar().toString())

        if (numbers)
            for (i in 48..57) lib.add(i.toChar().toString())

        if (symbols) {
            for (i in 33..47) lib.add(i.toChar().toString())
            for (i in 58..64) lib.add(i.toChar().toString())
        }
    }

    private fun generatePassword(length: Int) {
        for (i in 0 until length) {
            password += lib.random()
        }
    }

    private fun generateUniqueCharactersPassword(length: Int) {
        var element: String
        for (i in 0 until length) {
            element = lib.random()
            password += element
            lib.remove(element)
        }
    }
}