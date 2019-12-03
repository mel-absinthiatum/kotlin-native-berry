package com.melabsinthiatum

actual class Sample {
    actual fun checkMe() = 7
}

actual object Platform {
    actual val name: String = "iOS"
}

actual typealias Platform2 = Platform