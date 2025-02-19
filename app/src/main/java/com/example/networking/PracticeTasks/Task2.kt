package com.example.networking.PracticeTasks

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

fun main() {
    // URL of the server endpoint
    val url = URL("https://jsonplaceholder.typicode.com/posts") // Replace with your URL
    val connection = url.openConnection() as HttpURLConnection

    try {
        // Set up the connection
        connection.requestMethod = "POST"
        connection.setRequestProperty("Content-Type", "application/json") // Set content type
        connection.doOutput = true // Enable output for the request body

        // Create the JSON data to send in the request body
        val jsonInputString = """{"key1": "value1", "key2": "value2"}""" // Replace with your data

        // Write the data to the output stream
        OutputStreamWriter(connection.outputStream).use { writer ->
            writer.write(jsonInputString)
            writer.flush()
        }

        // Get the response code
        val responseCode = connection.responseCode
        println("Response Code: $responseCode")

        // Read the response
        val response = StringBuilder()
        BufferedReader(InputStreamReader(connection.inputStream)).use { reader ->
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                response.append(line)
            }
        }

        // Log the response
        println("Response: ${response.toString()}")

    } catch (e: Exception) {
        e.printStackTrace() // Log any exceptions
    } finally {
        connection.disconnect() // Disconnect the connection
    }
}