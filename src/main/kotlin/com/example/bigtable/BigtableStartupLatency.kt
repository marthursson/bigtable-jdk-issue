package com.example.bigtable

import com.google.cloud.bigtable.data.v2.BigtableDataClient
import com.google.cloud.bigtable.data.v2.BigtableDataSettings

fun main() {
    val startTime = System.currentTimeMillis()
    BigtableDataClient.create(
        BigtableDataSettings.newBuilder()
            .setProjectId("irrelevant")
            .setInstanceId("also irrelevant")
            // Channel priming takes forever
            .setRefreshingChannel(false)
            .build()
    ).use {
        println("Client created after ${System.currentTimeMillis() - startTime} millis")

        try {
            it.readRow("some_random_table", "some_random_key")
        } catch (e: Exception) {
            // Not relevant - we're just forcing the client to read something
        } finally {
            println("Statement executed after ${System.currentTimeMillis() - startTime} millis")
        }
    }

}