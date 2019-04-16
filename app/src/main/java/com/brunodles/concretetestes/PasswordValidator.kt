package com.brunodles.concretetestes

class PasswordValidator {

    private val conditions = listOf(
        "[A-Z]",
        "[a-z]",
        "[0-9]",
        "[^a-zA-Z0-9]",
        ".{8,}"
    )

    fun validate(password: String): Boolean {
        conditions.forEach { condition ->
            if (!password.contains(Regex(condition)))
                return false
        }
        return true
    }

}
