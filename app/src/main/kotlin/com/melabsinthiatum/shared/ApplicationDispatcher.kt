package com.melabsinthiatum.shared

import kotlinx.coroutines.*

internal actual val ApplicationDispatcher: CoroutineDispatcher
    get() = Dispatchers.Default