package br.com.vlabs.data.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> runDefaultContext(block: () -> T) =
    withContext(Dispatchers.Default) {
        block()
    }
