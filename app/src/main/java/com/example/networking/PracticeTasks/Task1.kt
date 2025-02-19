package com.example.networking.PracticeTasks

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun main() {
    // Define the URL to which the GET request will be sent
    val url = URL("https://jsonplaceholder.typicode.com/posts/1")

    // Open a connection to the URL
    val connection = url.openConnection() as HttpURLConnection

    try {
        // Set the request method to GET
        connection.requestMethod = "GET"
        // Get the response code
        val responseCode = connection.responseCode
        println("Response Code: $responseCode")

        // Read the response
        if (responseCode == HttpURLConnection.HTTP_OK) { // Success
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            val response = StringBuilder()
            var line: String?

            while (reader.readLine().also { line = it } != null) {
                response.append(line)
            }
            reader.close()

            // Log the response
            println("Response: $response")
        } else {
            println("GET request not successful")
        }
    } finally {
        // Disconnect the connection
        connection.disconnect()
    }
}