package com.melabsinthiatum.shared

import kotlinx.coroutines.*

internal actual val ApplicationDispatcher: kotlinx.coroutines.CoroutineDispatcher
    get() = Dispatchers.Default