package com.example.networking.PracticeTasks

//Safe Cast (as?): Returns null if the cast fails.
//Unsafe Cast (as): Throws an exception if the cast fails.
//Smart Cast: Automatically casts the variable after type checking.
//Type Checking (is): Used to check the type of an object.

    fun main() {
        val obj: Any = "Hello, Kotlin"

        // Safe cast
        val str: String? = obj as? String
        println(str) // Output: Hello, Kotlin

        val int: Int? = obj as? Int
        println(int) // Output: null



       // 🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎
//        val obj: Any = "Hello, sabbor"
//
//        // Unsafe cast
//        val str: String = obj as String
//        println(str) // Output: Hello, Kotlin

        // This will throw an exception
        // val int: Int = obj as Int // Uncommenting this line will throw ClassCastException

//🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎
//        fun printLength(obj: Any) {
//            if (obj is String) {
//                // Smart cast to String
//                println("Length: ${obj.length}") // No need to cast, obj is automatically treated as String
//            } else {
//                println("Not a String")
//            }
//        }

//    printLength("Hello, Kotlin") // Output: Length: 13
//    printLength(123) // Output: Not a String
//🍎🍎🍎🍎🍎🍎🍎🍎🍎🍎
//        val obj: Any = 42
//
//        if (obj is Int) {
//            println("It's an Int: $obj") // Smart cast to Int
//        } else {
//            println("Not an Int")
//        }

    }
